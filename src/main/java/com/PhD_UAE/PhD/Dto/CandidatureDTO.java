package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Candidature;
import lombok.Data;

@Data
public class CandidatureDTO {
    private int idcandidature; // Changement de int à Long pour la cohérence
    private boolean dossierComplet;
    private String etatCandidature;
    private Long idCandidat;
    private Long idsujet;

    public CandidatureDTO(Candidature candidature){
        this.idcandidature = candidature.getIdcandidature();
        this.dossierComplet = candidature.isDossierComplet();
        this.etatCandidature = candidature.getEtatCandidature();
        this.idCandidat = candidature.getCandidate().getIdCandidate();
        this.idsujet = candidature.getSujet().getIdSujet();
    }

    public CandidatureDTO() {
    }
}
