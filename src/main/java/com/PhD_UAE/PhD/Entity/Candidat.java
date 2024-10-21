package com.PhD_UAE.PhD.Entity;


import com.PhD_UAE.PhD.Entity.Bourse;
import com.PhD_UAE.PhD.Entity.Sujet;
import com.PhD_UAE.PhD.Entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidate;

    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String email;
    private String adresse;
    private String cin;
    private String cne;
    private String pays;
    private String tel;
    private String photo;
    private String diplomeObtenu;
    private String etablissementPrecedent;
    private boolean fontionnaire;

    // Relations
    @Getter
    @OneToOne(mappedBy = "candidate")
    private com.PhD_UAE.PhD.Entity.User user;

    //entretien
    @OneToMany(mappedBy = "candidat")
    private List<Entretien> entretien;

    @OneToMany(mappedBy = "candidate")
    private List<com.PhD_UAE.PhD.Entity.Bourse> bourses;

    @OneToMany(mappedBy = "candidat")
    private List<RendezVous> rendezVous;

    @ManyToMany
    @JoinTable(
            name = "Candidature",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "sujet_id"))
    private List<com.PhD_UAE.PhD.Entity.Sujet> sujets;
    public Candidat() {}

    public Long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Long idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDiplomeObtenu() {
        return diplomeObtenu;
    }

    public void setDiplomeObtenu(String diplomeObtenu) {
        this.diplomeObtenu = diplomeObtenu;
    }

    public String getEtablissementPrecedent() {
        return etablissementPrecedent;
    }

    public void setEtablissementPrecedent(String etablissementPrecedent) {
        this.etablissementPrecedent = etablissementPrecedent;
    }

    public boolean isFontionnaire() {
        return fontionnaire;
    }

    public void setFontionnaire(boolean fontionnaire) {
        this.fontionnaire = fontionnaire;
    }

    public List<com.PhD_UAE.PhD.Entity.Bourse> getBourses() {
        return bourses;
    }

    public void setBourses(List<Bourse> bourses) {
        this.bourses = bourses;
    }

    public List<com.PhD_UAE.PhD.Entity.Sujet> getSujets() {
        return sujets;
    }

    public void setSujets(List<Sujet> sujets) {
        this.sujets = sujets;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
