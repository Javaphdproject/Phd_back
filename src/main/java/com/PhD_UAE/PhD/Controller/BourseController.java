package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.BourseDTO;
import com.PhD_UAE.PhD.Service.BourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users/bourse")
public class BourseController {
    @Autowired
    private BourseService bourseService;
    
    @GetMapping("/all")
    public ResponseEntity<List<BourseDTO>> getAllBourses() {
        List<BourseDTO> bourses = bourseService.getAllBourses();
        return ResponseEntity.ok(bourses);
    }
    @PutMapping("/change-status/{id}")
    public void changeBourseStatus(@PathVariable Long id, @RequestParam String status) {
        bourseService.changeBourseStatus(id, status);
    }
}