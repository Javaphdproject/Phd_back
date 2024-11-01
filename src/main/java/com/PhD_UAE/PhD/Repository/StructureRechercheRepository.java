package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.StructureRecherche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StructureRechercheRepository extends JpaRepository<StructureRecherche, Integer> {
    Optional<StructureRecherche> findByNom(String nom);

    List<StructureRecherche> findAllByEtablissement_IdEtablissement(Long idEtablissement);
}