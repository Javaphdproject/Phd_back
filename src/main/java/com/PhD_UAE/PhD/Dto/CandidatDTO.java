package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.util.Date;


@Data
public class CandidatDTO {
    private Long idCandidate;
    private Long idUser;
    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String photo;
    private String diplomeObtenu;
    private String etablissementPrecedent;
    private boolean fonctionnaire;
    private int idEntretien;
    private Long idBourse;
    private int idRendezVous;
    private int idSujet;
}
