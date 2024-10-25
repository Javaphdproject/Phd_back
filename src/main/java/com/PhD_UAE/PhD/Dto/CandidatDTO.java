package com.PhD_UAE.PhD.DTO;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> 2bf09fe93d02164664978bb1570adea99f199712

import java.util.Date;
import java.util.List;

@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
public class CandidatDTO {
    private Long idCandidate; // Unique ID for Candidat
    private Long idUser; // Assuming you want to include the user's ID
=======
public class CandidatDTO {
    private Long idCandidate;
    private Long idUser;
    private String prenom;
    private String nom;
>>>>>>> 2bf09fe93d02164664978bb1570adea99f199712
    private Date dateNaissance;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
<<<<<<< HEAD
=======
    private String tel;
>>>>>>> 2bf09fe93d02164664978bb1570adea99f199712
    private String photo;
    private String diplomeObtenu;
    private String etablissementPrecedent;
    private boolean fonctionnaire;
<<<<<<< HEAD
    private List<Long> entretienIds; // List of interview IDs, if needed
    private List<Long> bourseIds; // List of scholarship IDs, if needed
    private List<Long> rendezVousIds; // List of appointment IDs, if needed
    private List<Long> sujetIds; // List of subject IDs
=======
    private int idEntretien;
    private Long idBourse;
    private int idRendezVous;
    private int idSujet;
>>>>>>> 2bf09fe93d02164664978bb1570adea99f199712
}
