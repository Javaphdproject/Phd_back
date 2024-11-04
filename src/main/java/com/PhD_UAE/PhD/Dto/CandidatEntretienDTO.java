package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Entretien;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CandidatEntretienDTO {
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

    // Candidat Additional Information
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

    // Educational Background
    private String nomLycee;
    private String paysBac;
    private String provinceBac;
    private String filiereBac;
    private String anneeObtentionBac;
    private String mentionBac;
    private double moyenneBac;

    private String nomUniversiteLicence;
    private String paysLicence;
    private String specialiteLicence;
    private String anneeObtentionLicence;
    private String mentionLicence;
    private double moyenneLicence;

    private String nomUniversiteMaster;
    private String paysMaster;
    private String statutMaster;
    private String specialiteMaster;
    private String anneeObtentionMaster;
    private String mentionMaster;
    private double moyenneMaster;

    // Languages
    private List<String> langues;
    private List<String> niveauxLangues;

    // Professional Experience
    private boolean experienceProfessionnelle;
    private String organisme;
    private List<String> fonctions;
    private List<String> secteurs;
    private List<String> duDates;
    private List<String> auDates;

    // Scanned Documents
    private String baccalaureatScanne;
    private String licenceScanne;
    private String masterScanne;
    private String releveNoteMasterScanne;
    private String releveNoteLicenceScanne;
    private String carteNationaleScanne;
    private String cvScanne;

    // Entretien Data
    private int idEntretien;
    private String resultat;
    private LocalDate date;
    private String status;

    public CandidatEntretienDTO(CandidatDTO candidat, Entretien entretien) {
        this.idCandidate = candidat.getIdCandidate();
        this.idUser = candidat.getIdUser();
        this.email = candidat.getEmail();
        this.prenom = candidat.getPrenom();
        this.nom = candidat.getNom();
        this.dateNaissance = candidat.getDateNaissance();
        this.adresse = candidat.getAdresse();
        this.cin = candidat.getCin();
        this.cne = candidat.getCne();
        this.pays = candidat.getPays();
        this.photo = candidat.getPhoto();
        this.fonctionnaire = candidat.isFonctionnaire();
        this.situationFamiliale = candidat.getSituationFamiliale();
        this.nationalite = candidat.getNationalite();
        this.paysNaissance = candidat.getPaysNaissance();
        this.provinceNaissance = candidat.getProvinceNaissance();
        this.lieuNaissance = candidat.getLieuNaissance();
        this.sexe = candidat.getSexe();
        this.codePostal = candidat.getCodePostal();
        this.emailInstitutionnel = candidat.getEmailInstitutionnel();
        this.handicape = candidat.isHandicape();
        this.professionPere = candidat.getProfessionPere();
        this.professionMere = candidat.getProfessionMere();
        this.candidatProfession = candidat.getCandidatProfession();
        this.organismeEmployeur = candidat.getOrganismeEmployeur();
        this.nomLycee = candidat.getNomLycee();
        this.paysBac = candidat.getPaysBac();
        this.provinceBac = candidat.getProvinceBac();
        this.filiereBac = candidat.getFiliereBac();
        this.anneeObtentionBac = candidat.getAnneeObtentionBac();
        this.mentionBac = candidat.getMentionBac();
        this.moyenneBac = candidat.getMoyenneBac();
        this.nomUniversiteLicence = candidat.getNomUniversiteLicence();
        this.paysLicence = candidat.getPaysLicence();
        this.specialiteLicence = candidat.getSpecialiteLicence();
        this.anneeObtentionLicence = candidat.getAnneeObtentionLicence();
        this.mentionLicence = candidat.getMentionLicence();
        this.moyenneLicence = candidat.getMoyenneLicence();
        this.nomUniversiteMaster = candidat.getNomUniversiteMaster();
        this.paysMaster = candidat.getPaysMaster();
        this.statutMaster = candidat.getStatutMaster();
        this.specialiteMaster = candidat.getSpecialiteMaster();
        this.anneeObtentionMaster = candidat.getAnneeObtentionMaster();
        this.mentionMaster = candidat.getMentionMaster();
        this.moyenneMaster = candidat.getMoyenneMaster();
        this.langues = candidat.getLangues();
        this.niveauxLangues = candidat.getNiveauxLangues();
        this.experienceProfessionnelle = candidat.isExperienceProfessionnelle();
        this.organisme = candidat.getOrganisme();
        this.fonctions = candidat.getFonctions();
        this.secteurs = candidat.getSecteurs();
        this.duDates = candidat.getDuDates();
        this.auDates = candidat.getAuDates();
        this.baccalaureatScanne = candidat.getBaccalaureatScanne();
        this.licenceScanne = candidat.getLicenceScanne();
        this.masterScanne = candidat.getMasterScanne();
        this.releveNoteMasterScanne = candidat.getReleveNoteMasterScanne();
        this.releveNoteLicenceScanne = candidat.getReleveNoteLicenceScanne();
        this.carteNationaleScanne = candidat.getCarteNationaleScanne();
        this.cvScanne = candidat.getCvScanne();

        // Setting Entretien data
        if (entretien != null) {
            this.idEntretien = entretien.getIdEntretien();
            this.resultat = entretien.getResultat();
            this.date = entretien.getDate();
            this.status = entretien.getStatus();
        }
    }
}
