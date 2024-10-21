package com.PhD_UAE.PhD.Entity;

import com.PhD_UAE.PhD.Entity.Candidat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bourse {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idBourse;
        private Date DateDemande;
        private String etatDemande;
        private String description;
        private Double montant;

        // Relations
        @ManyToOne
        @JoinColumn(name = "idCandidate")
        private Candidat candidate;

    public Bourse() {
    }

    public Long getIdBourse() {
        return idBourse;
    }

    public void setIdBourse(Long idBourse) {
        this.idBourse = idBourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Candidat getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidat candidate) {
        this.candidate = candidate;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Date getDateDemande() {
        return DateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        DateDemande = dateDemande;
    }
}
