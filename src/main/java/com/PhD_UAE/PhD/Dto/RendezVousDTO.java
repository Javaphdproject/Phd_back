package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RendezVousDTO {
    private int idRendezVous;
    private LocalDate dateRendezvous;
    private String etatRendezVous;
    private int idCandidate;
}
