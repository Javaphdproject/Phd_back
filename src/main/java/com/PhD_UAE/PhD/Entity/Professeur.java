package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesseur;

    private String prenom;
    private String nom;
    private String adresse;
    private String grade;
    private String tel;
    private String password;

    // Relationship with Sujet
    @OneToMany(mappedBy = "propose") // Make sure this matches the name in Sujet
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
