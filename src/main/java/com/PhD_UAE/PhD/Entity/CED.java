package com.PhD_UAE.PhD.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class CED {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCED; // Unique ID for CED

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    private User user;

    private String nom;

    // Relations
    @ManyToOne
    @JoinColumn(name = "idEtablissement")
    private Etablissement etablissement;

    @OneToMany(mappedBy = "ced")
    private List<Sujet> sujets;

    public CED() {}
}
