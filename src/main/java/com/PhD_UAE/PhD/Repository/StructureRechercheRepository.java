package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.StructureRecherche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StructureRechercheRepository extends JpaRepository<StructureRecherche, Integer> {

    List<StructureRecherche> findAllByEtablissement_IdEtablissement(Long idEtablissement);
}