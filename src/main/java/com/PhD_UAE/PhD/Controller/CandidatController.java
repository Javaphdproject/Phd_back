package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Exception.EntityNotFoundException;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/create/{userId}")

    public Candidat createCandidat(@RequestBody CandidatDTO candidatDTO, @PathVariable Long userId) {
        return candidatService.createCandidat(candidatDTO, userId);
    }
    @GetMapping("/getAll")
    public List<CandidatDTO> getAllCandidats() {
        System.out.println("Getting all candidats"); // Log to console
        return candidatService.getAllCandidats();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCandidatById(@PathVariable Long id) {
        CandidatDTO candidat = candidatService.getCandidatById(id);
        if (candidat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Candidat non trouvé avec l'identifiant : " + id);
        }
        return ResponseEntity.ok(candidat);
    }

}