package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StructureRecherche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSTr;
    private String typeStructure;
    private String nom;

    @OneToOne
    @JoinColumn(name = "idEtablissement", referencedColumnName = "idEtablissement")
    private Etablissement etablissement;
}