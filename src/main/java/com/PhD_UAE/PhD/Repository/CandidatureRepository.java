package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    Candidature findCandidatureByIdcandidature(Long idCandidature);
    @Query("SELECT c FROM Candidature c WHERE c.candidate.idCandidate = :idCandidate")
    Optional<Candidature> findCandidatureByIdCandidate(@Param("idCandidate") Long idCandidate);
    @Transactional
    @Modifying
    @Query("UPDATE Candidature c SET c.etatCandidature = :status WHERE c.candidate.idCandidate = :id")
    void updateCandidatureStatus(@Param("id") Long id, @Param("status") String status);

    @Query("SELECT COUNT(c) FROM Candidature c WHERE c.candidate.idCandidate = ?1")
    int countByCandidatId(Long candidateId);
}