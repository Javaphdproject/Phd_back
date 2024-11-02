package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StructureRecherche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSTr;

    private String typeStructure;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "idEtablissement", referencedColumnName = "idEtablissement")
    private Etablissement etablissement; // Many Structures can belong to one Etablissement

    @OneToMany(mappedBy = "structureRecherche") // One Structure can have many Professors
    private List<Professeur> professeurs;

    public StructureRecherche() {
    }
}
