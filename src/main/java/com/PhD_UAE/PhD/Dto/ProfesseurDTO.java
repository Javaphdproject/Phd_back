package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.UserType;
import lombok.Data;

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
    private UserDTO user;
    private UserType userType;

    public ProfesseurDTO(Professeur professeur){
        this.idProfesseur = professeur.getIdProfesseur();
        this.adresse = professeur.getAdresse();
        this.nom = getNom();
        this.prenom = getPrenom();
        this.tel = getTel();
        this.email = getEmail();
}

}
