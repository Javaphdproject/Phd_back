package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Entretien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntretienDTO {
    private int idEntretien;
    private String resultat;
    private LocalDate date;
    private Long idProfesseur;
    private Long idCandidate;

    public EntretienDTO(Entretien entretien) {
        this.idEntretien = entretien.getIdEntretien();
        this.resultat = entretien.getResultat();
        this.date = entretien.getDate();
        this.idProfesseur=entretien.getProfesseur().getIdProfesseur();
        this.idCandidate=entretien.getCandidat().getIdCandidate();
    }
}
