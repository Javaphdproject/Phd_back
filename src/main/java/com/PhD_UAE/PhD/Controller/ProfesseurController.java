package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.ProfesseurDTO;
import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Entity.Sujet;
import com.PhD_UAE.PhD.Service.CedService;
import com.PhD_UAE.PhD.Service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users/professeurs")
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
    @GetMapping("/{id}/sujets")
    public ResponseEntity<List<SujetDTO>> getSubjectsByProfessorId(@PathVariable Long id) {
        List<Sujet> sujets = cedService.getSubjectsByProfessorId(id);
        List<SujetDTO> sujetDTOs = sujets.stream()
                .map(sujet -> new SujetDTO(sujet.getIdSujet(), sujet.getTitre(), sujet.getProjet(), sujet.getDescription()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(sujetDTOs);
    }
}