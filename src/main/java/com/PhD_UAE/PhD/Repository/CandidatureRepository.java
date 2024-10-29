package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    Candidature findCandidatureByIdcandidature(Long idCandidature);
}