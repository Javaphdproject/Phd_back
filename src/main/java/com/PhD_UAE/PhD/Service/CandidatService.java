package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Exception.EntityNotFoundException;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.UserRepository;
import com.PhD_UAE.PhD.Transformer.CandidatTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidatService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private CandidatTransformer candidatTransformer;

    public List<CandidatDTO> getAllCandidats() {
        List<Candidat> candidats = candidatRepository.findAll();
        return candidats.stream().map(candidatTransformer::toDTO).toList();
    }

    public CandidatDTO getCandidatById(Long id) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidat non trouvé avec l'identifiant : " + id));
        return candidatTransformer.toDTO(candidat);
    }
    public Candidat createCandidat(CandidatDTO candidatDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Utilisation du transformer
        Candidat candidat = candidatTransformer.toEntity(candidatDTO);
        candidat.setUser(user);

        // Enregistrement du candidat
        return candidatRepository.save(candidat);
    }


}