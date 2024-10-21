package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidate; // Unique ID for Candidat

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    private User user;

    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String tel;
    private String photo;
    private String diplomeObtenu;
    private String etablissementPrecedent;
    private boolean fonctionnaire;

    // Relations
    @OneToMany(mappedBy = "candidat")
    private List<Entretien> entretiens;

    @OneToMany(mappedBy = "candidate")
    private List<Bourse> bourses;

    @OneToMany(mappedBy = "candidat")
    private List<RendezVous> rendezVous;

    @ManyToMany
    @JoinTable(
            name = "Candidature",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "sujet_id"))
    private List<Sujet> sujets;

    public Candidat() {}
}
