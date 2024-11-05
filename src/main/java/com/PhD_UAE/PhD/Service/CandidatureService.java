
package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Entity.Candidature;
import com.PhD_UAE.PhD.Entity.Sujet;
import com.PhD_UAE.PhD.Repository.CandidatureRepository;
import com.PhD_UAE.PhD.Repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatureService {
    @Autowired
    private SujetRepository sujetRepository;
    @Autowired
    private CandidatureRepository candidatureRepository;



    // Method to count candidatures by candidate ID
    public int countCandidaturesByCandidateId(Long candidateId) {
        return candidatureRepository.countByCandidatId(candidateId);
      }

    public List<SujetDTO> getAllSujets() {
        List<Sujet> sujets = sujetRepository.findAll(); // Fetch all sujets
        return sujets.stream()
                .map(SujetDTO::new)
                .collect(Collectors.toList());
    }

}