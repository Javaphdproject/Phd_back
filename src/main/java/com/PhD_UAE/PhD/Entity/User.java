package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String prenom;
    private String nom;
    private String email;
    private String mdp;  // Assurez-vous que ce champ est sécurisé (crypté en production)
    private String tel;

    // One-to-one relationship with Candidat
    @OneToOne(mappedBy = "user")
    private Candidat candidat;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    @Override
    public String getPassword() {
        return this.mdp; // Retourne le mot de passe de l'utilisateur.
    }

    @Override
    public String getUsername() {
        return this.email; // Retourne l'email comme nom d'utilisateur.
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // L'utilisateur n'est pas expiré (ajustez selon votre logique).
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // L'utilisateur n'est pas verrouillé (ajustez selon votre logique).
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Les informations d'identification ne sont pas expirées (ajustez selon votre logique).
    }

    @Override
    public boolean isEnabled() {
        return true; // L'utilisateur est activé (ajustez selon votre logique).
    }

    public User(Long idUser) {
        this.idUser = idUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.userType.name()));
    }
}
