package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CandidatDTO {
    private Long idCandidate;
    private Long idUser;
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
    private int idEntretien;
    private Long idBourse;
    private int idRendezVous;
    private int idSujet;
}
