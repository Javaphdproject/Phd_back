package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.StructureRechercheDTO;
import com.PhD_UAE.PhD.Service.StructureRechercheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users/structures-recherche")
public class StructureRechercheController {

    @Autowired
    private StructureRechercheService structureRechercheService;

    @PostMapping("/create/{etablissementId}")
    public ResponseEntity<String> createStructureRecherche(@PathVariable Long etablissementId, @RequestBody StructureRechercheDTO structureRechercheDTO) {
        String result = structureRechercheService.createStructureRecherche(etablissementId, structureRechercheDTO);
        return ResponseEntity.ok(result);
    }

}
