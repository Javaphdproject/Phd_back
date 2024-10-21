/*
package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidat")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular to connect
public class CandidatController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("/login")
    public ResponseEntity<Candidat> login(@RequestParam String email, @RequestParam String password) {
        Candidat candidat = candidatService.login(email, password);
        if (candidat != null) {
            return ResponseEntity.ok(candidat);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}

 */