package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    List<Etablissement> findAllByCed_IdCED(Long idCED);
    Optional<Etablissement> findByNomEtablissement(String nomEtablissement);


}