package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phd/sujet")
public class SujetController {
    @Autowired
    public SujetService service;
    @PostMapping("/addsujet/{idUser}")
    public ResponseEntity<String> addsujet(@RequestBody SujetDTO sujetDTO, @PathVariable Long idUser) {
        String result = service.addSujet(sujetDTO, idUser);
        return ResponseEntity.ok(result);
    }



    @PutMapping("/updateSujet/{id}")
    public ResponseEntity<String> updatesujet(@RequestBody SujetDTO sujetDTO, @PathVariable("id") long id) {
        return service.updateSujet(sujetDTO, id);
    }
    @GetMapping("/getSujet/{idUser}")
    public List<SujetDTO> getAllSujets(@PathVariable Long idUser) {
        List<SujetDTO> list = service.getallSujets(idUser);
        return list ;
    }
    @DeleteMapping("/deleteSujet/{id}")
    public ResponseEntity<String> deleteSujet(@PathVariable Long id) {
        boolean isDeleted = service.deleteSujet(id);
        if (isDeleted) {
            return ResponseEntity.ok("Sujet with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sujet with ID " + id + " not found");
        }
    }


}
