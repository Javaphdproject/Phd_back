package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Sujet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SujetDTO {
    private Long idSujet;

    private String titre;
    private Long idProfesseur;

    public SujetDTO(Long idSujet, String titre, Long idProfesseur) {
        this.idSujet = idSujet;
        this.titre = titre;
        this.idProfesseur = idProfesseur;
    }

    private String projet;

    private String description;

    public SujetDTO(Long idSujet, String titre, Long idProfesseur, String projet, String description) {
        this.idSujet = idSujet;
        this.titre = titre;
        this.idProfesseur = idProfesseur;
        this.projet = projet;
        this.description = description;
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
