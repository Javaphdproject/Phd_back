package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.SujetDTO;
import com.PhD_UAE.PhD.Entity.Candidature;
import com.PhD_UAE.PhD.Entity.Professeur;
import com.PhD_UAE.PhD.Entity.Sujet;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.CandidatureRepository;
import com.PhD_UAE.PhD.Repository.ProfessorRepository;
import com.PhD_UAE.PhD.Repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SujetService {

    @Autowired
    private SujetRepository sujetRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CandidatureRepository candidatureRepository;

    public String addSujet(SujetDTO sujetDTO, long IdUser) {
        Long idprof = professorRepository.findIdProfByUserId(IdUser);
        Professeur professeur = professorRepository.findById(idprof)
                .orElseThrow(() -> new IllegalArgumentException("Professor not found with id: " + idprof));
        Sujet sujet = new Sujet();
        sujet.setProfesseur(professeur);
        sujet.setTitre(sujetDTO.getTitre());
        sujet.setProjet(sujetDTO.getProjet());
        sujet.setDescription(sujetDTO.getDescription());
        sujetRepository.save(sujet);

        return "Sujet added successfully";
    }


    public ResponseEntity<String> updateSujet(SujetDTO sujetDTO, long id) {
        Optional<Sujet> existingSujet = sujetRepository.findById(id);

        if (existingSujet.isPresent()) {
            Sujet sujet = existingSujet.get();
            sujet.setTitre(sujetDTO.getTitre());
            sujet.setProjet(sujetDTO.getProjet());
            sujet.setDescription(sujetDTO.getDescription());
            sujetRepository.save(sujet);

            return new ResponseEntity<>("Sujet updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sujet not found", HttpStatus.NOT_FOUND);
        }
    }

    public List<SujetDTO> getallSujets(Long idUser) {
        Long idProf = professorRepository.findIdProfByUserId(idUser);
        Professeur professeur = professorRepository.findById(idProf)
                .orElseThrow(() -> new IllegalArgumentException("Professor not found with id: " + idProf));
        return sujetRepository.findAll().stream()
                .filter(sujet -> sujet.getProfesseur() != null && sujet.getProfesseur().getIdProfesseur().equals(idProf))
                .map(sujet -> new SujetDTO(
                        sujet.getIdSujet(),
                        sujet.getTitre(),
                        sujet.getProfesseur() != null ? sujet.getProfesseur().getIdProfesseur() : null,
                        sujet.getProjet(),
                        sujet.getDescription()
                ))
                .collect(Collectors.toList());
    }


    public boolean deleteSujet(Long id) {
        if (sujetRepository.existsById(id)) {
            sujetRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}