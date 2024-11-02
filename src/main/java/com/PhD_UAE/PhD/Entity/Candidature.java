package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcandidature; // Changez de int à Long pour la cohérence

    private boolean dossierComplet;
    private String etatCandidature;

    // Many-to-One relation with Candidat
    @ManyToOne
    @JoinColumn(name = "idCandidate", referencedColumnName = "idCandidate", nullable = false)
    private Candidat candidat;

    // One-to-One relation with Sujet
    @OneToOne
    @JoinColumn(name = "idSujet", referencedColumnName = "idSujet", nullable = false)
    private Sujet sujet;

    public Candidature() {}
}
