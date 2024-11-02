package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesseur;

    private String adresse;
    private String grade;
    private String password;

    @ManyToOne
    @JoinColumn(name = "ced_id", referencedColumnName = "idCED")
    private CED ced;

    @ManyToOne
    @JoinColumn(name = "idStructureRecherche", referencedColumnName = "idSTr")
    private StructureRecherche structureRecherche; // Many Professors can belong to one Structure

    @OneToMany(mappedBy = "propose")
    private List<Sujet> sujets;

    @OneToMany(mappedBy = "professeur")
    private List<Entretien> entretiens;

    @ManyToOne
    @JoinColumn(name = "idEtablissement")
    private Etablissement etablissement;

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    private User user;

    public Professeur() {}
}
