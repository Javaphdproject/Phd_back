package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcandidature;
    private boolean dossierComplet;
    private String etatCandidature;

    // Update the mapping here
    @OneToMany(mappedBy = "candidature")
    private List<Candidat> candidats;

    public Candidature() {}
    @ManyToOne
    @JoinColumn(name = "idCandidate", referencedColumnName = "idCandidate")
    private Candidat candidate;

    @ManyToOne
    @JoinColumn(name = "idSujet", referencedColumnName = "idSujet")
    private Sujet sujet;


}