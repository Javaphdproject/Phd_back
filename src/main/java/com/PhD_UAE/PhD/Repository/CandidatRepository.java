package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    Candidat findCandidatByIdCandidate(Long idCandidat);
    Optional<Candidat> findByUser_Email(String email);
    /*@Query("SELECT c FROM Candidat c JOIN c.user u WHERE c.user.idUser = :userId")
    List<Candidat> findCandidatByUserId(@Param("userId") Long userId);

    // Méthode pour récupérer tous les candidats avec les noms et prénoms
    @Query("SELECT c FROM Candidat c JOIN c.user u")
    List<Candidat> findAllWithUserDetails();*/
    Candidat findByIdCandidate(Long idCandidate);
    Optional<Candidat> findById(Long idCandidate);
}