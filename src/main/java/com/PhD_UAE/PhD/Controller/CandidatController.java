package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phd/candidates")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/save")
    public Candidat registerCandidat(@RequestBody Candidat candidat, @RequestParam Long userId) {
        return candidatService.saveCandidat(candidat, userId);
    }
}
