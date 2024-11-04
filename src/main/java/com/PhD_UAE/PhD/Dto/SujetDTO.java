package com.PhD_UAE.PhD.Dto;

import lombok.Data;

@Data
public class SujetDTO {
    private Long idSujet;
    private String titre;
    private String projet;
    private String description;

    public SujetDTO(Long idSujet, String titre, String projet, String description) {
        this.idSujet = idSujet;
        this.titre = titre ;
        this.projet=projet;
        this.description= description;

    }
}
