package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatureDTO;
import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Candidature;
import com.PhD_UAE.PhD.Entity.Sujet;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.CandidatureRepository;
import com.PhD_UAE.PhD.Repository.SujetRepository;
import com.PhD_UAE.PhD.Service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/phd/candidature")
public class CandidatureControlleur {
    @Autowired
    private CandidatureService candidatureService;
    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private SujetRepository sujetRepository;
@Autowired
private CandidatureRepository candidatureR;
    @PostMapping("/add/{id_user}/{id_sujet}")
    public ResponseEntity<String> addCandidature(@PathVariable("id_user") Long userId, @PathVariable("id_sujet") Long sujetId) {
        System.out.println("User ID: " + userId); // Log userId

        Long idCandidat = candidatRepository.findIdCandidatByUserId(userId);
        System.out.println("Found Candidate ID: " + idCandidat); // Log idCandidat

        if (idCandidat == null) {
            return new ResponseEntity<>("No candidate found for the given user ID.", HttpStatus.NOT_FOUND);
        }

        // Check if the candidate has more than 3 candidatures
        int existingCandidaturesCount = candidatureService.countCandidaturesByCandidateId(idCandidat);
        if (existingCandidaturesCount > 3) {
            return new ResponseEntity<>("Le candidat a déjà 3 candidatures ou plus.", HttpStatus.BAD_REQUEST);
        }

        // Proceed to create and save the new candidature
        Candidat candidat = candidatRepository.findById(idCandidat)
                .orElseThrow(() -> new IllegalArgumentException("Candidate not found with id: " + idCandidat));
        candidat.setIdCandidate(idCandidat);

        Candidature candidature = new Candidature();
        candidature.setCandidate(candidat);

        // Set the subject
        Sujet subject = new Sujet();
        subject.setIdSujet(sujetId); // Assuming subject ID is provided in URL
        candidature.setSujet(subject);

        // Save the new candidature
        candidatureR.save(candidature);

        // Return a success message
        return new ResponseEntity<>("Candidature added successfully.", HttpStatus.OK);
    }


    @GetMapping("/get-all-sujets") // New endpoint
    public ResponseEntity<List<SujetDTO>> getAllSujets() {
        List<SujetDTO> sujets = candidatureService.getAllSujets();
        return new ResponseEntity<>(sujets, HttpStatus.OK);
    }
}

