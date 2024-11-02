package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Entretien;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InterviewWithCandidateDTO {
    private int idEntretien;
    private String resultat;
    private LocalDate date;
    private String status;
    private String candidateName;
    private String candidatePrenom;

    public InterviewWithCandidateDTO(Entretien entretien) {
        this.idEntretien = entretien.getIdEntretien();
        this.resultat = entretien.getResultat();
        this.date = entretien.getDate();
        this.status = entretien.getStatus();
        this.candidateName = entretien.getCandidat().getUser().getNom();
        this.candidatePrenom = entretien.getCandidat().getUser().getPrenom();
    }
}
