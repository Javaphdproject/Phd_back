package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Repository.CandidatRepository;
import com.PhD_UAE.PhD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    public String createCandidat(CandidatDTO candidatDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Candidat candidat = new Candidat();
        candidat.setUser(user);
        candidat.setDateNaissance(candidatDTO.getDateNaissance());
        candidat.setAdresse(candidatDTO.getAdresse());
        candidat.setCin(candidatDTO.getCin());
        candidat.setCne(candidatDTO.getCne());
        candidat.setPays(candidatDTO.getPays());
        candidat.setPhoto(candidatDTO.getPhoto());
        candidat.setFonctionnaire(candidatDTO.isFonctionnaire());
        candidat.setSituationFamiliale(candidatDTO.getSituationFamiliale());
        candidat.setNationalite(candidatDTO.getNationalite());
        candidat.setPaysNaissance(candidatDTO.getPaysNaissance());
        candidat.setProvinceNaissance(candidatDTO.getProvinceNaissance());
        candidat.setLieuNaissance(candidatDTO.getLieuNaissance());
        candidat.setSexe(candidatDTO.getSexe());
        candidat.setCodePostal(candidatDTO.getCodePostal());
        candidat.setEmailInstitutionnel(candidatDTO.getEmailInstitutionnel());
        candidat.setHandicape(candidatDTO.isHandicape());
        candidat.setProfessionPere(candidatDTO.getProfessionPere());
        candidat.setProfessionMere(candidatDTO.getProfessionMere());
        candidat.setCandidatprofession(candidatDTO.getCandidatprofession());
        candidat.setOrganismeEmployeur(candidatDTO.getOrganismeEmployeur());

        // Save the Candidat
        candidatRepository.save(candidat);
        return "Candidat created successfully";
    }
}
