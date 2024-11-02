package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.PlanningPreincriptionDTO;
import com.PhD_UAE.PhD.Entity.PlanningPreinscription;
import com.PhD_UAE.PhD.Entity.CED; // Importez l'entité CED
import com.PhD_UAE.PhD.Repository.CedRepository;
import com.PhD_UAE.PhD.Repository.PlanningPreinscriptionRepository;
import com.PhD_UAE.PhD.Repository.PlanningPreinscriptionRepository;
import com.PhD_UAE.PhD.Repository.CedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanningPreinscriptionService {

    @Autowired
    private PlanningPreinscriptionRepository planningRepository;

    @Autowired
    private CedRepository cedRepository; // Dépendance pour accéder à CED

    public PlanningPreinscription createPlanning(PlanningPreincriptionDTO planningDTO) {
        PlanningPreinscription planning = new PlanningPreinscription();
        planning.setAnneeUniversitaire(planningDTO.getAnneeUniversitaire());
        planning.setTitre(planningDTO.getTitre());
        planning.setDateReinscription(planningDTO.getDateReinscription());
        planning.setDateDepotDossier(planningDTO.getDateDepotDossier());
        planning.setDatePropositionSujets(planningDTO.getDatePropositionSujets());
        planning.setDateValidationSujets(planningDTO.getDateValidationSujets());
        planning.setDateConvocationEtudiants(planningDTO.getDateConvocationEtudiants());
        planning.setDateAffichageResultats(planningDTO.getDateAffichageResultats());
        planning.setDateInscription(planningDTO.getDateInscription());

        // Gérer l'objet CED
        if (planningDTO.getCedId() != null) {
            CED ced = cedRepository.findById(planningDTO.getCedId())
                    .orElseThrow(() -> new RuntimeException("CED non trouvé avec l'ID: " + planningDTO.getCedId()));
            planning.setCed(ced);
        } else {
            throw new RuntimeException("L'ID du CED ne peut pas être nul.");
        }

        return planningRepository.save(planning);
    }

    public PlanningPreinscription getPlanningById(Long id) {
        return planningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planning non trouvé avec l'ID: " + id));
    }

    public List<PlanningPreincriptionDTO> getAllPlannings() {
        List<PlanningPreinscription> plannings = planningRepository.findAll();
        return plannings.stream()
                .map(PlanningPreincriptionDTO::new)
                .collect(Collectors.toList());
    }

}
