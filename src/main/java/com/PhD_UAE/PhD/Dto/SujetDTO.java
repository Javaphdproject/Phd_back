package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Sujet;
import lombok.Data;

@Data
public class SujetDTO {
    private Long idSujet;
    private String titre;
    private String projet;
    private String description;
    private  Long idProfesseur;

    public SujetDTO(Long idSujet, String titre, String projet, String description) {
        this.idSujet = idSujet;
        this.titre = titre ;
        this.projet=projet;
        this.description= description;

    }
    public SujetDTO(Long idSujet, String titre, Long idProfesseur, String projet, String description) {
        this.idSujet = idSujet;
        this.titre = titre;
        this.idProfesseur = idProfesseur;
        this.projet = projet;
        this.description = description;
    }
    public SujetDTO(Long idSujet, String titre, Long idProfesseur) {
        this.idSujet = idSujet;
        this.titre = titre;
        this.idProfesseur = idProfesseur;
    }

    public SujetDTO(Sujet sujet) {
        if (sujet != null) {
            this.idSujet = sujet.getIdSujet();
            this.titre = sujet.getTitre();
            this.idProfesseur = sujet.getProfesseur().getIdProfesseur();
            this.projet = sujet.getProjet();
            this.description = sujet.getDescription();

        }
    }
}