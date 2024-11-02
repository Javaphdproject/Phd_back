package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
public class PlanningPreinscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anneeUniversitaire;
    private String titre;

    // Dates for various phases of the registration
    private LocalDate dateReinscription;
    private LocalDate dateDepotDossier;
    private LocalDate datePropositionSujets;
    private LocalDate dateValidationSujets;
    private LocalDate dateConvocationEtudiants;
    private LocalDate dateAffichageResultats;
    private LocalDate dateInscription;

    @ManyToOne
    @JoinColumn(name = "idCED", nullable = false)
    private CED ced;


    public PlanningPreinscription() {}
}
