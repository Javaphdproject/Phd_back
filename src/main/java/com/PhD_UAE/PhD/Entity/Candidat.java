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
    private Long idCandidate; // ID unique pour le candidat

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user; // Association avec l'entité User

    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String photo;
    private boolean fonctionnaire;
    private String situationFamiliale;
    private String nationalite;
    private String paysNaissance;
    private String provinceNaissance;
    private String lieuNaissance;
    private String sexe;
    private String codePostal;
    private String emailInstitutionnel;
    private boolean handicape;
    private String professionPere;
    private String professionMere;
    private String candidatProfession;
    private String organismeEmployeur;

    // Baccalauréat
    private String nomLycee;
    private String paysBac;
    private String provinceBac;
    private String filiereBac;
    private String anneeObtentionBac;
    private String mentionBac;
    private double moyenneBac;

    // Licence
    private String nomUniversiteLicence;
    private String paysLicence;
    private String specialiteLicence;
    private String anneeObtentionLicence;
    private String mentionLicence;
    private double moyenneLicence;

    // Master
    private String nomUniversiteMaster;
    private String paysMaster;
    private String statutMaster;
    private String specialiteMaster;
    private String anneeObtentionMaster;
    private String mentionMaster;
    private double moyenneMaster;

    // Langues
    private String langues; // Liste de langues sous forme de chaîne (ex: "Français, Anglais")
    private String niveauxLangues; // Liste de niveaux sous forme de chaîne (ex: "B1, C2")

    // Expérience professionnelle
    private boolean experienceProfessionnelle;
    private String organismes; // Liste d'organismes sous forme de chaîne
    private String fonctions; // Liste de fonctions sous forme de chaîne
    private String secteurs; // Liste de secteurs sous forme de chaîne
    private String duDates; // Liste de dates de début sous forme de chaîne
    private String auDates; // Liste de dates de fin sous forme de chaîne

    // Documents scannés
    private String baccalaureatScanne;
    private String licenceScanne;
    private String masterScanne;
    private String releveNoteMasterScanne;
    private String releveNoteLicenceScanne;
    private String carteNationaleScanne;
    private String cvScanne;

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

    // Référence à Candidature
    @ManyToOne
    @JoinColumn(name = "id_candidature")
    private Candidature candidature;

    public Candidat() {}
}
