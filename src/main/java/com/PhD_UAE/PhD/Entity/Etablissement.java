package com.PhD_UAE.PhD.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "idCED", nullable = false)
    private CED ced;

    // Relations
    @Getter
    @OneToMany(mappedBy = "etablissement")
    private List<Professeur> professeurs;

    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StructureRecherche> structuresRecherche = new ArrayList<>();
    public Etablissement() {
    }

}
