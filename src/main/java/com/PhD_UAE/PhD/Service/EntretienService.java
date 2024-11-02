package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.EntretienDTO;
import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Entretien;
import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.CandidatureRepository;
import com.PhD_UAE.PhD.Repository.EntretienRepository;
import com.PhD_UAE.PhD.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class EntretienService {
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private EntretienRepository entretienRepository;
    private final EmailService emailService;
    @Autowired
    public EntretienService(EmailService emailService) {
        this.emailService = emailService;
    }
    public List<Object[]> getAcceptedCAndidate(long IdUser) {
        return candidatRepository.findAcceptedCandidates(IdUser);
    }

    public String callingInterview(Long idUser, EntretienDTO dto, Long id) {
        Long idProf = professorRepository.findIdProfByUserId(idUser);
        Long idCandidat = candidatRepository.findIdCandidatByUserId(id);
        System.out.println(id);
        System.out.println(dto.getIdCandidate());
        System.out.println("idProf: " + idProf);
        System.out.println("idCandidat: " + idCandidat);
        if ( idCandidat == null) {
            return "User not found or does not have an associated  candidate record.";
        }
        if (idProf == null){
            return "User not found or does not have an associated professor record.";
        }

        Entretien entretien = new Entretien();
        entretien.setDate(dto.getDate());

        Professeur professeur = professorRepository.findById(idProf)
                .orElseThrow(() -> new IllegalArgumentException("Professor not found with id: " + idProf));
        professeur.setIdProfesseur(idProf);
        entretien.setProfesseur(professeur);
        Candidat candidat = candidatRepository.findById(idCandidat)
                .orElseThrow(() -> new IllegalArgumentException("Candidate not found with id: " + idCandidat));
        candidat.setIdCandidate(idCandidat);
        entretien.setCandidat(candidat);
         entretien.setStatus("Accepted");
        String subject = "Interview Scheduled";
        UserDTO CandidatInfo = candidatRepository.findUserInfo(idCandidat);
        if (CandidatInfo == null) {
            return "Candidate information could not be retrieved.";
        }
        entretienRepository.save(entretien);
        candidatureRepository.updateCandidatureStatus(idCandidat, "called");


        String body = String.format("Dear %s,\n\nYour interview has been scheduled for %s.\n\nBest regards,\nYour Company",
                CandidatInfo.getNom(), dto.getDate());
        System.out.println( "nom "+CandidatInfo.getNom());
        long startTime = System.currentTimeMillis();
        emailService.sendEmail(CandidatInfo.getEmail(), subject, body);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to send email: " + (endTime - startTime) + "ms");        System.out.println(CandidatInfo.getEmail());
        return "Interview scheduled successfully";
    }

    public ResponseEntity<String> refuseCandidature(Long idUser, long id) {
        // Find the candidate's ID based on the user ID
        Long idCandidat = candidatRepository.findIdCandidatByUserId(id);
        // Fetch the candidate details
        Candidat candidat = candidatRepository.findById(idCandidat)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidate not found with id: " + idCandidat));

        // Retrieve candidate's user information
        UserDTO candidatInfo = candidatRepository.findUserInfo(idCandidat);
        candidatureRepository.updateCandidatureStatus(idCandidat, "Refused");
        if (candidatInfo == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Candidate information could not be retrieved.");
        }

        // Prepare email content
        String subject = "Interview";
        String body = String.format("Dear %s,\n\nWe regret to inform you that you have been rejected for the interview.\n\nBest regards,\nYour Company", candidatInfo.getNom());

        // Check if the email address is present
        if (candidatInfo.getEmail() != null && !candidatInfo.getEmail().isEmpty()) {
            try {
                // Attempt to send the email
                emailService.sendEmail(candidatInfo.getEmail(), subject, body);
                System.out.println("Email sent to: " + candidatInfo.getEmail());
                return ResponseEntity.ok("Rejection email sent to candidate successfully.");
            } catch (Exception e) {
                // Log the exception and return an error response
                System.out.println("Failed to send email to: " + candidatInfo.getEmail() + " - Error: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to send rejection email to the candidate.");
            }
        } else {
            // Handle the case where the email address is missing
            System.out.println("Email address is missing for candidate.");
            return ResponseEntity.badRequest().body("Email address is missing for the candidate.");
        }
    }


    public List<Object[]> ListEntretien(Long idUser) {
        Long idProf = professorRepository.findIdProfByUserId(idUser);
        Professeur professeur = professorRepository.findById(idProf)
                .orElseThrow(() -> new IllegalArgumentException("Professor not found with id: " + idProf));
        return  entretienRepository.findCandidateInfoByProfessorId(idProf);
    }

    public ResponseEntity<String> noteCandidat(EntretienDTO entretien, Long userId) {
    return  ResponseEntity.ok("");
    }
}
