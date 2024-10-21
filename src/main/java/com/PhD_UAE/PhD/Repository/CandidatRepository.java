package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
 /*   Optional<Candidat> findCandidatById(Long id);

    void deleteEmployeeById(Long id);

    Optional<Candidat> findByEmailAndPassword(String email, String password);*/
}
