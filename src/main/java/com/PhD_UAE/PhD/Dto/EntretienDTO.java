package com.PhD_UAE.PhD.Dto;

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
    private int idProfesseur;
    private int idCandidate;
}
