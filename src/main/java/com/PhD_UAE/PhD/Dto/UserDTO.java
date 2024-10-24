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

    public UserDTO(Long idUser, String prenom, String nom, String email, UserType userType) {
        this.idUser = idUser;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.userType = userType;
    }
}
