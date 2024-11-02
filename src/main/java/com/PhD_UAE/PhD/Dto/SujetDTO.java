package com.PhD_UAE.PhD.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
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

}
