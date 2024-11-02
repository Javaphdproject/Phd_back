package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    Candidature findCandidatureByIdcandidature(Long idCandidature);
    @Transactional
    @Modifying
    @Query("UPDATE Candidature c SET c.etatCandidature = :status WHERE c.candidate.idCandidate = :id")
    void updateCandidatureStatus(@Param("id") Long id, @Param("status") String status);

}