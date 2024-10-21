package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntretien ;
    private String resultat;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "idProfesseur", referencedColumnName= "idProfesseur")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "idCandidate", referencedColumnName= "idCandidate")
    private Candidat candidat;
}
