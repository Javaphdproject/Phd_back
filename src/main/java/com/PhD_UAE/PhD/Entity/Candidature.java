package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcandidature;
    private boolean dossierComplet ;
    private String etatCandidature;
    @OneToMany(mappedBy = "candidat")
    private List<Candidat> candidat;
}
