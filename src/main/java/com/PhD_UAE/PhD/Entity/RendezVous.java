
package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name="rendezvous")
@Getter
@Setter
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRendezVous;

    private LocalDate dateRendezvous;

    private String etatRendezVous;

    @ManyToOne
    @JoinColumn(name = "idCandidate", referencedColumnName = "idCandidate") // FK column in RendezVous table
    private Candidat candidat;



}
