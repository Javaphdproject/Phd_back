package com.PhD_UAE.PhD.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntretienDTO {
    private Long idEntretien;
    private BigDecimal resultat;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long idProfesseur;
    private Long idCandidate;
    private  String status;

    public EntretienDTO(Long idEntretien) {

        this.idEntretien = idEntretien;
    }
    public  EntretienDTO(long idEntretien, BigDecimal Resultat, LocalDate date) {
        this.idEntretien = idEntretien;
        this.resultat = Resultat;
        this.date = date;
    }

    public EntretienDTO(Long idEntretien,Long idCandidate) {
        this.idEntretien = idEntretien;
        this.idCandidate = idCandidate;
    }

    public Long getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(Long idEntretien) {
        this.idEntretien = idEntretien;
    }

    public BigDecimal getResultat() {
        return resultat;
    }

    public void setResultat(BigDecimal resultat) {
        this.resultat = resultat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Long idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }
}
