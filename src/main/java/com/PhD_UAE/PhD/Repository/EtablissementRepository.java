package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    List<Etablissement> findAllByCed_IdCED(Long idCED);
    Optional<Etablissement> findByNomEtablissement(String nomEtablissement);
    @Query("SELECT e FROM Etablissement e LEFT JOIN FETCH e.structuresRecherche")
    List<Etablissement> findAllWithStructures();

}