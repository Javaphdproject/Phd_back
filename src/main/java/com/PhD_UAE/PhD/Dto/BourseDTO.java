package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Bourse;
import lombok.Data;

import java.util.Date;

@Data
public class BourseDTO {
    private Long idBourse;
    private Date dateDemande;
    private String etatDemande;
    private String description;
    private Double montant;
    private String nomCandidat;
    private String prenomCandidat;
    private String emailCandidat;
    private Long idCandidate;
    public BourseDTO(Bourse bourse) {
        this.dateDemande = bourse.getDateDemande();
        this.description = bourse.getDescription();
        this.montant = bourse.getMontant();
        this.etatDemande= bourse.getEtatDemande();
        this.idCandidate =bourse.getCandidate().getIdCandidate();
        this.idBourse =bourse.getIdBourse();
    }
    public BourseDTO() {
    }
}



