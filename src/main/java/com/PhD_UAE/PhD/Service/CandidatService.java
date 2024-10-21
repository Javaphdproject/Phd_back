/*package com.PhD_UAE.PhD.Service;


import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Exception.CandidatNotFoundException;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CandidatService {
    private final CandidatRepository candidatRepository;
    @Autowired

    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public Candidat login(String email, String password) {
        Optional<Candidat> candidat = candidatRepository.findByEmailAndPassword(email, password);
        return candidat.orElse(null);
    }

    public Candidat addCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }
    public List<Candidat> findAllCandidats() {
        return candidatRepository.findAll();
    }
    public Candidat updateCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }
    public Candidat findCandidatById(Long id) {
        return candidatRepository.findCandidatById(id)
                .orElseThrow(() -> new CandidatNotFoundException(("Candidate  by id"+ id + "was not found")));
    }
    public  void deleteCandidat(Long id) {
        candidatRepository.deleteEmployeeById(id);
    }
}
*/