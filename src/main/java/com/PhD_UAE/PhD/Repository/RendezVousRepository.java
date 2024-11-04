package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {
    Optional<RendezVous> findByCandidat_IdCandidate(int idCandidate);

}
