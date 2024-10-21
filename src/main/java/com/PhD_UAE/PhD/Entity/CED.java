package com.PhD_UAE.PhD.Entity;


import com.PhD_UAE.PhD.Entity.Etablissement;
import com.PhD_UAE.PhD.Entity.Sujet;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CED {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCED;

    private String nom;


    // Relations
    @ManyToOne
    @JoinColumn(name = "idEtablissement")
    private Etablissement etablissement;

    @OneToMany(mappedBy = "ced")
    private List<Sujet> sujets;
    public CED() {}

    public Long getIdCED() {
        return idCED;
    }

    public void setIdCED(Long idCED) {
        this.idCED = idCED;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public List<Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(List<Sujet> sujets) {
        this.sujets = sujets;
    }
}

