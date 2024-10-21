package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSujet;

    @Getter
    private String titre;
    private String projet;
    @Getter
    private String description;
    // Relations
    @Getter
    @ManyToOne
    @JoinColumn(name = "idProfesseur")
    private Professeur propose;

    // Add this method
    @Getter
    @ManyToOne
    @JoinColumn(name = "idCED") // Assuming you have a foreign key for CED
    private com.PhD_UAE.PhD.Entity.CED ced; // Add this line

    @Getter
    @ManyToMany(mappedBy = "sujets")
    private List<Candidat> candidates;

    public void setIdSujet(Long idSujet) {
        this.idSujet = idSujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public void setPropose(Professeur propose) {
        this.propose = propose;
    }

    public void setCed(CED ced) {
        this.ced = ced; // Add this method
    }

    public void setCandidates(List<Candidat> candidates) {
        this.candidates = candidates;
    }
}
