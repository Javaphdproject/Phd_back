package com.PhD_UAE.PhD.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class BourseDTO {
    private Long idBourse;
    private Date dateDemande;
    private String etatDemande;
    private String description;
    private Double montant;
    private Long idCandidate;
}