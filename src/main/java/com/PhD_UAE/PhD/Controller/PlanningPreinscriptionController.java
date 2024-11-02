package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.PlanningPreincriptionDTO;
import com.PhD_UAE.PhD.Entity.PlanningPreinscription;
import com.PhD_UAE.PhD.Service.PlanningPreinscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/phd/planning")
public class PlanningPreinscriptionController {

    @Autowired
    private PlanningPreinscriptionService planningPreinscription;

    @PostMapping("/create")
    public ResponseEntity<PlanningPreincriptionDTO> createPlanning(@RequestBody PlanningPreincriptionDTO planningDTO) {
        PlanningPreinscription planning = planningPreinscription.createPlanning(planningDTO);
        return ResponseEntity.ok(new PlanningPreincriptionDTO(planning));
    }

    @GetMapping("/get")
    public ResponseEntity<List<PlanningPreincriptionDTO>> getAllPlannings() {
        List<PlanningPreincriptionDTO> plannings = planningPreinscription.getAllPlannings();
        return ResponseEntity.ok(plannings);
    }

}
