package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professeur, Long> {
    List<Professeur> findAllByStructureRecherche_IdSTr(Long idStr);
}
