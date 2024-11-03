package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet, Long> {

    List<Sujet> findByPropose_IdProfesseur(Long professorId);

}
