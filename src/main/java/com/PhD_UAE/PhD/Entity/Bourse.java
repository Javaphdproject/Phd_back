package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
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


}
