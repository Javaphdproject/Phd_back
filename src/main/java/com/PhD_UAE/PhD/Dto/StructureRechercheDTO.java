package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.StructureRecherche;
import lombok.Data;

@Data
public class StructureRechercheDTO {
    private Integer idSTr;
    private String typeStructure;
    private String nom;
    private Long idEtablissement;

    public StructureRechercheDTO(StructureRecherche structureRecherche) {
        this.idSTr = structureRecherche.getIdSTr();
        this.typeStructure = structureRecherche.getTypeStructure();
        this.nom = structureRecherche.getNom();
        this.idEtablissement = structureRecherche.getEtablissement().getIdEtablissement();
    }

    public StructureRechercheDTO(String nom, String typeStructure) {
        this.nom = nom;
        this.typeStructure = typeStructure;
    }

    public StructureRechercheDTO() {
    }
}