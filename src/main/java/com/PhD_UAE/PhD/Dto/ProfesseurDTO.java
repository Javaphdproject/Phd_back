package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.UserType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProfesseurDTO {
    private Long idProfesseur;
    private String prenom;
    private String nom;
    private String email;
    private String adresse;
    private String tel;
    private String grade;
    private String password;
    private UserType userType;
    private Long cedId;
    private Long idEtablissement;
    private Integer idStructureRecherche;

    // Constructor for converting Professeur entity to DTO
    public ProfesseurDTO(Professeur professeur) {
        this.idProfesseur = professeur.getIdProfesseur();
        this.adresse = professeur.getAdresse();
        this.grade = professeur.getGrade();
        this.prenom = professeur.getUser().getPrenom();
        this.nom = professeur.getUser().getNom();
        this.email = professeur.getUser().getEmail();
        this.tel = professeur.getUser().getTel();
        this.idEtablissement = professeur.getEtablissement().getIdEtablissement();
        this.idStructureRecherche = professeur.getStructureRecherche().getIdSTr();
    }

    public ProfesseurDTO() {}
}
