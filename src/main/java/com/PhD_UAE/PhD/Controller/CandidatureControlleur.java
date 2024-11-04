package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatureDTO;
import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Candidature;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phd/candidature")
public class CandidatureControlleur {
    @Autowired
    private CandidatureService candidatureService;
    @Autowired
    private CandidatRepository candidatRepository;
    @PostMapping("/add/{id}")
    public ResponseEntity<String> addCandidature(@RequestBody CandidatureDTO candidatureDTO, @PathVariable long id   ) {
        Long candidateId = candidatRepository.findIdCandidatByUserId(id);

        // Check if the candidate has more than 3 candidatures
        int existingCandidaturesCount = candidatureService.countCandidaturesByCandidateId(candidateId);
        if (existingCandidaturesCount >= 3) {
            return new ResponseEntity<>("Le candidat a déjà 3 candidatures ou plus.", HttpStatus.BAD_REQUEST);
        }

        // Create and save the new candidature
        Candidature candidature = new Candidature();
        candidature.setDossierComplet(candidatureDTO.isDossierComplet());
        candidature.setEtatCandidature(candidatureDTO.getEtatCandidature());

        // Set the candidate and subject
        Candidat candidat = new Candidat();
        candidat.setIdCandidate(candidateId); // Assuming candidate ID is provided in DTO
        candidature.setCandidate(candidat);

        // You would also need to set the subject, similar to how the candidate is set

        candidatureService.saveCandidature(candidature);
        return new ResponseEntity<>("Candidature ajoutée avec succès.", HttpStatus.CREATED);
}
    @GetMapping("/get-all-sujets") // New endpoint
    public ResponseEntity<List<SujetDTO>> getAllSujets() {
        List<SujetDTO> sujets = candidatureService.getAllSujets();
        return new ResponseEntity<>(sujets, HttpStatus.OK);
    }
}

