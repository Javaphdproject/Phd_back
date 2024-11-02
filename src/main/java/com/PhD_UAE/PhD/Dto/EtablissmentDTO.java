package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Etablissement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class EtablissmentDTO {
    private Long idEtablissement;
    private String nomEtablissement;
    private String adresseEtablissement;
    private String ville;

    public EtablissmentDTO(Long idEtablissement, String adresseEtablissement, String nomEtablissement, String ville) {
        this.idEtablissement =idEtablissement;
        this.adresseEtablissement= adresseEtablissement;
        this.nomEtablissement = nomEtablissement;
        this.ville = ville;
    }

    public EtablissmentDTO(Etablissement etablissement) {
        this.idEtablissement = etablissement.getIdEtablissement();
        this.adresseEtablissement = etablissement.getAdresseEtablissement();
        this.nomEtablissement = etablissement.getNomEtablissement();
        this.ville = etablissement.getVille();
    }

    public EtablissmentDTO() {
    }
}
