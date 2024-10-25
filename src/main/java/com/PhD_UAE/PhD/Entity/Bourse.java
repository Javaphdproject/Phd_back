package com.PhD_UAE.PhD.Entity;

import com.PhD_UAE.PhD.Entity.Candidat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
