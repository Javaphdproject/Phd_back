package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/phd/candidat")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/create/{userId}")

    public Candidat createCandidat(@RequestBody CandidatDTO candidatDTO, @PathVariable Long userId) {
        return candidatService.createCandidat(candidatDTO, userId);
    }
    @GetMapping("/{id}")
    public Optional<CandidatDTO> getCandidatById(@PathVariable Long id) {
        return candidatService.getCandidatById(id);
    }
}
