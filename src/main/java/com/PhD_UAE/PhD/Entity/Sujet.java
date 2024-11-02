package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSujet;

    private String titre;

    private String projet;

    private String description;


    @ManyToOne
    @JoinColumn(name = "idProfesseur")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "idCED")
    private CED ced;

    @Getter
    @ManyToMany(mappedBy = "sujets")
    private List<Candidat> candidates;
}
