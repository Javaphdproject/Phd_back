package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.BourseDTO;
import com.PhD_UAE.PhD.Service.BourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phd/bourse")
public class BourseController {
    @Autowired
    private BourseService bourseService;

    @GetMapping("/en-cours")
    public ResponseEntity<List<BourseDTO>> getBoursesEnCours() {
        List<BourseDTO> bourses = bourseService.getBoursesEnCours();
        return ResponseEntity.ok(bourses);

    }
}