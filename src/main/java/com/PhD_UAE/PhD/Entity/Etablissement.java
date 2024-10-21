package com.PhD_UAE.PhD.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtablissement;

    private String nomEtablissement;
    private String adresseEtablissement;
    private String ville;

    // Relations
    @Getter
    @OneToMany(mappedBy = "etablissement")
    private List<com.PhD_UAE.PhD.Entity.Professeur> professeurs;

    @OneToOne(mappedBy = "etablissement")
    private StructureRecherche structureRecherche;
    public Etablissement() {
    }

}
