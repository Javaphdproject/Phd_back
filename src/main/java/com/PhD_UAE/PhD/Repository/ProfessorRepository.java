package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professeur, Long> {
    List<Professeur> findAllByStructureRecherche_IdSTr(Long idStr);
    @Query("SELECT p.idProfesseur FROM Professeur p WHERE p.user.idUser = :idUser")
    Long findIdProfByUserId(@Param("idUser") Long idUser);
}
