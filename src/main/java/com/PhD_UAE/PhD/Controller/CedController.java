package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.*;
import com.PhD_UAE.PhD.Entity.Etablissement;
import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.CandidatureRepository;
import com.PhD_UAE.PhD.Service.CedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "/phd/auth/users/ced")
public class CedController {

    @Autowired
    private CedService CedService;
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping("/get-all-etablissement")
    public ResponseEntity<List<EtablissmentDTO>> getAllEtablissement(){
        List<EtablissmentDTO> etablissement = CedService.getAllEtablissement();
        return new ResponseEntity<>(etablissement,HttpStatus.OK);
    }

    @GetMapping("/get-all-ced")
    public ResponseEntity<List<CedDTO>> getAllCed(){
        List<CedDTO> cedDTO = CedService.getAllCed();
        return new ResponseEntity<>(cedDTO,HttpStatus.OK);
    }

    @GetMapping("/get-ced-etablissement/{idCED}")
    public ResponseEntity<List<EtablissmentDTO>> getAllEtablissementByCED(@PathVariable Long idCED){
        List<EtablissmentDTO> etablissement = CedService.getAllEtablissementByCED(idCED);
        return new ResponseEntity<>(etablissement,HttpStatus.OK);
    }

    @GetMapping("/get-etablissememnt-str/{idEtablissement}")
    public ResponseEntity<List<StructureRechercheDTO>> getStructureByEtablissement(@PathVariable Long idEtablissement){
        List<StructureRechercheDTO> structureRecherche = CedService.getAllStrByEtablissement(idEtablissement);
        return new ResponseEntity<>(structureRecherche,HttpStatus.OK);
    }

    @GetMapping("/get-str-prof/{idStr}")
    public ResponseEntity<List<ProfesseurDTO>> getProfBystr(@PathVariable Long idStr){
        List<ProfesseurDTO> professeurs = CedService.getProfBystr(idStr);
        return new ResponseEntity<>(professeurs,HttpStatus.OK);
    }


   /* @PostMapping("/create-professeur")
    public ResponseEntity<String> createProfesseur(@RequestBody ProfesseurDTO professeurDTO) {
        try {
            System.out.println("Received Professeur Data: " + professeurDTO);
            CedService.createProfesseur(professeurDTO, cedId);
            return new ResponseEntity<>("Professeur created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to create Professeur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    //candidature
    @GetMapping("/get-all-candidature")
    public ResponseEntity<List<CandidatureDTO>> getAllCandidature(){
        List<CandidatureDTO> candidature = CedService.getAllCandidature();
        return new ResponseEntity<>(candidature,HttpStatus.OK);
    }

    @GetMapping("/get-candidature/{idCandidature}")
    public ResponseEntity<CandidatureDTO> getCandidatureByID(@PathVariable Long idCandidature){
        CandidatureDTO candidature = CedService.getCandidatureByID(idCandidature);
        if (candidature ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(candidature,HttpStatus.OK);
    }

 /*   @GetMapping("/get-candidat/{idCandidat}")
    public ResponseEntity<CandidatDTO> getCandidatById(@PathVariable Long idCandidat){
        CandidatDTO candidat = CedService.getCandidatById(idCandidat);
        if (candidat ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(candidat,HttpStatus.OK);
    }*/

    @PutMapping("/update-candidature-status/{idCandidature}/{newStatus}")
    public ResponseEntity<String> updateCandidatureStatus(@PathVariable Long idCandidature, @PathVariable String newStatus){
        CandidatureDTO candidature = CedService.updateCandidatureStatus(idCandidature, newStatus);

        if (candidature == null) {
            return new ResponseEntity<>("Candidature not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Candidature status updated successfully", HttpStatus.OK);
    }
    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            Path filePath = Paths.get("src/main/resources/static/images").resolve(filename);
            Resource resource =  new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")  // Generic binary type
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //admin rendezvous
    @GetMapping("/getCandidates")
    public List<InterviewWithCandidateDTO> getAcceptedInterviews() {
        List<InterviewWithCandidateDTO> interviews = CedService.getAcceptedInterviews();
        return interviews;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRendezVous(@RequestBody RendezVousDTO rendezVousDTO) {
        String result = CedService.addRendezVous(rendezVousDTO);
        return ResponseEntity.ok(result);
    }

//candidat

    @GetMapping("/candidature/by-candidate/{idCandidate}")
    public ResponseEntity<CandidatureDTO> getCandidatureByCandidateId(@PathVariable Long idCandidate) {
        Long idcandidat = candidatRepository.findIdCandidatByUserId(idCandidate);
        CandidatureDTO candidatureDTO = CedService.getCandidatureByCandidateId(idcandidat);
        if (candidatureDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(candidatureDTO, HttpStatus.OK);
    }


}