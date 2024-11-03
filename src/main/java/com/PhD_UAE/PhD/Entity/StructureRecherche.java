package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @ToString.Exclude // Avoid circular reference in toString
    @EqualsAndHashCode.Exclude // Avoid circular reference in equals/hashCode
    private Etablissement etablissement;

    @OneToMany(mappedBy = "structureRecherche") // One Structure can have many Professors
    private List<Professeur> professeurs;

    public StructureRecherche() {
    }
}
