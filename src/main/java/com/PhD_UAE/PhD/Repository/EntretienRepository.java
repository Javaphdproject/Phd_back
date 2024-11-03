package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Entretien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntretienRepository extends CrudRepository<Entretien, Integer> {

    @Query("SELECT e.candidat FROM Entretien e WHERE e.status = 'accepted'")
    List<Candidat> findAcceptedCandidates();


    List<Entretien> findByStatus(String status);

}
