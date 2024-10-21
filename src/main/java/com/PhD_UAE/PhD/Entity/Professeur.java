package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Professeur {
    // Getters and Setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesseur;

    @Getter
    private String prenom;
    @Getter
    private String nom;
    @Getter
    private String email;
    @Getter
    private String adresse;
    private String grade;
    @Getter
    private String tel;
    @Getter
    private String password;
    private String passwordConfirme;

    // Relations
    @Getter
    @OneToOne(mappedBy = "professeur")
    private com.PhD_UAE.PhD.Entity.User user;

    @Getter
    @OneToMany(mappedBy = "propose")
    private List<com.PhD_UAE.PhD.Entity.Sujet> sujets;

    @OneToMany(mappedBy = "professeur")
    private List<Entretien> entretiens ;


    @Getter
    @ManyToOne
    @JoinColumn(name = "idEtablissement") // The foreign key column in the Professeur table
    private Etablissement etablissement;

    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirme(String passwordConfirme) {
        this.passwordConfirme = passwordConfirme;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSujets(List<Sujet> sujets) {
        this.sujets = sujets;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
