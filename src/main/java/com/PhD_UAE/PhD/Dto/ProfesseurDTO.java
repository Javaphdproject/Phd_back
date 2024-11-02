package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long cedId;
    private Long idEtablissement;
    private Integer idStructureRecherche;
    private String etablissementNom;
    private String structureRechercheNom;
    // Constructor for converting Professeur entity to DTO
    public ProfesseurDTO(Professeur professeur) {
        this.idProfesseur = professeur.getIdProfesseur();
        this.prenom = professeur.getUser().getPrenom();
        this.nom = professeur.getUser().getNom();
        this.email = professeur.getUser().getEmail();
        this.adresse = professeur.getAdresse();
        this.tel = professeur.getUser().getTel();
        this.grade = professeur.getGrade();
        this.cedId=professeur.getCed().getIdCED();
        this.password=professeur.getPassword();
        this.userType = professeur.getUser().getUserType();
        this.etablissementNom = professeur.getEtablissement() != null ? professeur.getEtablissement().getNomEtablissement() : null;
        this.structureRechercheNom = professeur.getStructureRecherche() != null ? professeur.getStructureRecherche().getNom() : null;


    }


    public ProfesseurDTO() {}
}
