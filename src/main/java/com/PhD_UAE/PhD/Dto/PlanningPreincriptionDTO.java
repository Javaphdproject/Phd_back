package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.PlanningPreinscription;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PlanningPreincriptionDTO {
    private Long id;
    private String anneeUniversitaire;
    private String titre;

    // Dates pour les différentes étapes de l'inscription
    private LocalDate dateReinscription;
    private LocalDate dateDepotDossier;
    private LocalDate datePropositionSujets;
    private LocalDate dateValidationSujets;
    private LocalDate dateConvocationEtudiants;
    private LocalDate dateAffichageResultats;
    private LocalDate dateInscription;

    private Long cedId;

    public PlanningPreincriptionDTO() {
    }
    public PlanningPreincriptionDTO(PlanningPreinscription planningPreinscription) {
        this.id = planningPreinscription.getId();
        this.anneeUniversitaire=planningPreinscription.getAnneeUniversitaire();
        this.titre=planningPreinscription.getTitre();
        this.dateReinscription=planningPreinscription.getDateReinscription();
        this.dateAffichageResultats=planningPreinscription.getDateAffichageResultats();
        this.dateValidationSujets=planningPreinscription.getDateValidationSujets();
        this.datePropositionSujets=planningPreinscription.getDatePropositionSujets();
        this.dateConvocationEtudiants=planningPreinscription.getDateConvocationEtudiants();
        this.dateInscription=planningPreinscription.getDateInscription();
        this.dateDepotDossier=planningPreinscription.getDateDepotDossier();
        this.cedId = planningPreinscription.getCed() != null ? planningPreinscription.getCed().getIdCED() : null;
    }
}
