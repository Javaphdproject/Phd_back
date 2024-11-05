package com.PhD_UAE.PhD.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntretien ;
    private BigDecimal resultat;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private  String status;

    @ManyToOne
    @JoinColumn(name = "idProfesseur", referencedColumnName= "idProfesseur")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "idCandidate", referencedColumnName= "idCandidate")
    private Candidat candidat;

    public Entretien(Long idEntretien) {
        this.idEntretien = idEntretien;
    }

}
