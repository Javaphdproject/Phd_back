package com.PhD_UAE.PhD.Dto;

import com.PhD_UAE.PhD.Entity.UserType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {

    private Long idUser;
    private String prenom;
    private String nom;
    private String email;
    private UserType userType;
    private String mdp;
    private String tel;

    public UserDTO(String nom, String prenom, String email, long idUser) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.idUser = idUser;
    }

    public UserDTO() {

    }
}