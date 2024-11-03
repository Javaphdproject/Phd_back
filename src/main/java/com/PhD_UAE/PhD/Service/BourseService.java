package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.BourseDTO;
import com.PhD_UAE.PhD.Entity.Bourse;
import com.PhD_UAE.PhD.Repository.BourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BourseService {
    @Autowired
    private BourseRepository bourseRepository;

    public List<BourseDTO> getBoursesEnCours() {
        List<Bourse> bourses = bourseRepository.findByEtatDemande("en cours");
        return bourses.stream()
                .map(bourse -> {
                    BourseDTO dto = new BourseDTO(bourse);
                    // Récupérer les informations du candidat
                    if (bourse.getCandidate() != null && bourse.getCandidate().getUser() != null) {
                        dto.setNomCandidat(bourse.getCandidate().getUser().getNom());
                        dto.setPrenomCandidat(bourse.getCandidate().getUser().getPrenom());
                        dto.setEmailCandidat(bourse.getCandidate().getUser().getEmail());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
