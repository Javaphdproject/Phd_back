package com.PhD_UAE.PhD.Entity;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Professeur;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String role;
    private String email;
    private String mdp;
    private String login;

    // Relations
    @OneToOne
    private Candidat candidate;

    @OneToOne
    private Professeur professeur;
}
