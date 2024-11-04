package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    Candidature findCandidatureByIdcandidature(Long idCandidature);
    @Query("SELECT c FROM Candidature c WHERE c.candidat.idCandidate = :idCandidate")
    Optional<Candidature> findCandidatureByIdCandidate(@Param("idCandidate") Long idCandidate);
}