package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
