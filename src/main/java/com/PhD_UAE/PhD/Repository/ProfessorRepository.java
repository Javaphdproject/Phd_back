package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professeur, Long> {
    List<Professeur> findAllByStructureRecherche_IdSTr(Long idStr);
    List<Professeur> findAllByUser_UserType(UserType userType);
    @Query("SELECT p.idProfesseur FROM Professeur p WHERE p.user.idUser = :idUser")
    Long findIdProfByUserId(@Param("idUser") Long idUser);

}