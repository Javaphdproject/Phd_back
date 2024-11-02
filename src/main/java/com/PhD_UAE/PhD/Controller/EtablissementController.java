package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.EtablissmentDTO;
import com.PhD_UAE.PhD.Service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phd/auth/users/etablissements")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @PostMapping("/create/{cedId}")
    public ResponseEntity<String> createEtablissement(@PathVariable Long cedId, @RequestBody EtablissmentDTO etablissementDTO) {
        String result = etablissementService.createEtablissement(cedId, etablissementDTO);
        return ResponseEntity.ok(result);
    }
}
