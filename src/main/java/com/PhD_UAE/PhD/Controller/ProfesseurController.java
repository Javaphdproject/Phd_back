package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.ProfesseurDTO;
import com.PhD_UAE.PhD.Service.CedService;
import com.PhD_UAE.PhD.Service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phd/professeurs")
public class ProfesseurController {

    @Autowired
    private CedService professeurService;

    @PostMapping("/create/{cedId}")
    public ResponseEntity<String> createProfesseur(@PathVariable Long cedId, @RequestBody ProfesseurDTO professeurDTO) {
        String result = professeurService.registerProfesseur(professeurDTO, cedId);
        return ResponseEntity.ok(result);
    }
    @Autowired
    private CedService cedService;

    @GetMapping
    public List<ProfesseurDTO> getAllProfesseurs() {
        return cedService.getAllProfesseurs();
    }
    // Récupérer les données d'un professeur spécifique par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfesseurDTO> getProfessorById(@PathVariable Long id) {
        ProfesseurDTO professeurDTO = cedService.getProfessorById(id);
        if (professeurDTO != null) {
            return ResponseEntity.ok(professeurDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
