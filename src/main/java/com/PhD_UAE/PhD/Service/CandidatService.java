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

        // Baccalauréat
        candidat.setNomLycee(candidatDTO.getNomLycee());
        candidat.setPaysBac(candidatDTO.getPaysBac());
        candidat.setProvinceBac(candidatDTO.getProvinceBac());
        candidat.setFiliereBac(candidatDTO.getFiliereBac());
        candidat.setAnneeObtentionBac(candidatDTO.getAnneeObtentionBac());
        candidat.setMentionBac(candidatDTO.getMentionBac());
        candidat.setMoyenneBac(candidatDTO.getMoyenneBac());

        // Licence
        candidat.setNomUniversiteLicence(candidatDTO.getNomUniversiteLicence());
        candidat.setPaysLicence(candidatDTO.getPaysLicence());
        candidat.setSpecialiteLicence(candidatDTO.getSpecialiteLicence());
        candidat.setAnneeObtentionLicence(candidatDTO.getAnneeObtentionLicence());
        candidat.setMentionLicence(candidatDTO.getMentionLicence());
        candidat.setMoyenneLicence(candidatDTO.getMoyenneLicence());

        // Master
        candidat.setNomUniversiteMaster(candidatDTO.getNomUniversiteMaster());
        candidat.setPaysMaster(candidatDTO.getPaysMaster());
        candidat.setStatutMaster(candidatDTO.getStatutMaster());
        candidat.setSpecialiteMaster(candidatDTO.getSpecialiteMaster());
        candidat.setAnneeObtentionMaster(candidatDTO.getAnneeObtentionMaster());
        candidat.setMentionMaster(candidatDTO.getMentionMaster());
        candidat.setMoyenneMaster(candidatDTO.getMoyenneMaster());

        // Langues
        candidat.setLangues(candidatDTO.getLangues());
        candidat.setNiveauxLangues(candidatDTO.getNiveauxLangues());

        // Expérience professionnelle
        candidat.setExperienceProfessionnelle(candidatDTO.isExperienceProfessionnelle());
        candidat.setOrganisme(candidatDTO.getOrganisme());
        candidat.setFonctions(candidatDTO.getFonctions());
        candidat.setSecteurs(candidatDTO.getSecteurs());
        candidat.setDuDates(candidatDTO.getDuDates());
        candidat.setAuDates(candidatDTO.getAuDates());

        // Documents scannés
        candidat.setBaccalaureatScanne(candidatDTO.getBaccalaureatScanne());
        candidat.setLicenceScanne(candidatDTO.getLicenceScanne());
        candidat.setMasterScanne(candidatDTO.getMasterScanne());
        candidat.setReleveNoteMasterScanne(candidatDTO.getReleveNoteMasterScanne());
        candidat.setReleveNoteLicenceScanne(candidatDTO.getReleveNoteLicenceScanne());
        candidat.setCarteNationaleScanne(candidatDTO.getCarteNationaleScanne());
        candidat.setCvScanne(candidatDTO.getCvScanne());

        // Sauvegarder le Candidat
        candidatRepository.save(candidat);
        return "Candidat created successfully";
    }
}
