package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Bourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BourseRepository extends JpaRepository<Bourse, Long> {
    List<Bourse> findByEtatDemande(String etatDemande);

}
