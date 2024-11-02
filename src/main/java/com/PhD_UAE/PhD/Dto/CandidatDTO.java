package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CandidatDTO {
    private Long idCandidate;
    private Long idUser;
    private String email;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String photo;
    private boolean fonctionnaire;
    // Informations supplémentaires
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
    private List<String> langues;
    private List<String> niveauxLangues;

    private boolean experienceProfessionnelle;
    private String organisme;
    private List<String> fonctions;
    private List<String> secteurs;
    private List<String> duDates;
    private List<String> auDates;
    //private  List<String> candidatProfessions;

    // Documents scannés
    private String baccalaureatScanne;
    private String licenceScanne;
    private String masterScanne;
    private String releveNoteMasterScanne;
    private String releveNoteLicenceScanne;
    private String carteNationaleScanne;
    private String cvScanne;
}
