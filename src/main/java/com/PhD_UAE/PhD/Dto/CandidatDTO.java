package com.PhD_UAE.PhD.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidatDTO {
    private Long idCandidate; // Unique ID for Candidat
    private Long idUser; // Assuming you want to include the user's ID
    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String photo;
    private String diplomeObtenu;
    private String etablissementPrecedent;
    private boolean fonctionnaire;
    private List<Long> entretienIds; // List of interview IDs, if needed
    private List<Long> bourseIds; // List of scholarship IDs, if needed
    private List<Long> rendezVousIds; // List of appointment IDs, if needed
    private List<Long> sujetIds; // List of subject IDs
}
