package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.EntretienDTO;
import com.PhD_UAE.PhD.Entity.Entretien;
import com.PhD_UAE.PhD.Service.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/phd/Professeur")
@RestController
public class EntretienCOntrolleur {
    @Autowired
    EntretienService profService;
    @GetMapping("/candidatesaccp/{idUser}")
    public List<Object[]> candidatesaccp(@PathVariable Long idUser) {

        return profService.getAcceptedCAndidate(idUser);
    }
    @PostMapping("/calltoentretien/{idUser}/{id}")
    public ResponseEntity<String> callingInterview(@PathVariable Long idUser,@PathVariable Long id, @RequestBody EntretienDTO entretien) {
        String result = profService.callingInterview(idUser, entretien, id);
        if (result.equals("Interview scheduled successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @PostMapping("/refusecandidat/{idUser}/{id}")
    public ResponseEntity<String>   refuseCandidature(@PathVariable Long idUser, @PathVariable long id) {

        return profService.refuseCandidature(idUser, id);
    }
    @GetMapping("/listentretien/{idUser}")
    public List<Object[]> ListEntretien(@PathVariable Long idUser) {

        return profService.ListEntretien(idUser);
    }
     @PostMapping("/notecandidat/{userId}")
    public ResponseEntity<String> notecandidat(@RequestBody EntretienDTO entretien, @PathVariable Long userId) {
        return profService.noteCandidat(entretien, userId);
     }

}