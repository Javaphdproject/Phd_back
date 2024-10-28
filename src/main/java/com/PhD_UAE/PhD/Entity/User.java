package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String prenom;
    private String nom;
    private String email;
    private String mdp;
    private String tel;
    // One-to-one relationship with Candidat
    @OneToOne(mappedBy = "user")
    private Candidat candidat;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public User(Long idUser) {
        this.idUser = idUser;
    }
}