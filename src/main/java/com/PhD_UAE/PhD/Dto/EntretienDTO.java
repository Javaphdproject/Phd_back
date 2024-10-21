package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntretienDTO {
    private int idEntretien;
    private String resultat;
    private LocalDate date;
    private int idProfesseur;
    private int idCandidate;
}
