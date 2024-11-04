package com.PhD_UAE.PhD.Transformer;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CandidatTransformer extends Transformer<Candidat, CandidatDTO> {

    @Override
    public CandidatDTO toDTO(Candidat candidat) {
        CandidatDTO dto = new CandidatDTO();

        dto.setIdCandidate(candidat.getIdCandidate());
        dto.setIdUser(candidat.getUser().getIdUser());
        dto.setEmail(candidat.getUser().getEmail());
        dto.setPrenom(candidat.getUser().getPrenom());
        dto.setNom(candidat.getUser().getNom());
        dto.setDateNaissance(candidat.getDateNaissance());
        dto.setAdresse(candidat.getAdresse());
        dto.setCin(candidat.getCin());
        dto.setCne(candidat.getCne());
        dto.setPays(candidat.getPays());
        dto.setPhoto(candidat.getPhoto());
        dto.setFonctionnaire(candidat.isFonctionnaire());
        dto.setSituationFamiliale(candidat.getSituationFamiliale());
        dto.setNationalite(candidat.getNationalite());
        dto.setPaysNaissance(candidat.getPaysNaissance());
        dto.setProvinceNaissance(candidat.getProvinceNaissance());
        dto.setLieuNaissance(candidat.getLieuNaissance());
        dto.setSexe(candidat.getSexe());
        dto.setCodePostal(candidat.getCodePostal());
        dto.setEmailInstitutionnel(candidat.getEmailInstitutionnel());
        dto.setHandicape(candidat.isHandicape());
        dto.setProfessionPere(candidat.getProfessionPere());
        dto.setProfessionMere(candidat.getProfessionMere());
        dto.setCandidatProfession(candidat.getCandidatProfession());
        dto.setOrganismeEmployeur(candidat.getOrganismeEmployeur());

        // Baccalauréat
        dto.setNomLycee(candidat.getNomLycee());
        dto.setPaysBac(candidat.getPaysBac());
        dto.setProvinceBac(candidat.getProvinceBac());
        dto.setFiliereBac(candidat.getFiliereBac());
        dto.setAnneeObtentionBac(candidat.getAnneeObtentionBac());
        dto.setMentionBac(candidat.getMentionBac());
        dto.setMoyenneBac(candidat.getMoyenneBac());

        // Licence
        dto.setNomUniversiteLicence(candidat.getNomUniversiteLicence());
        dto.setPaysLicence(candidat.getPaysLicence());
        dto.setSpecialiteLicence(candidat.getSpecialiteLicence());
        dto.setAnneeObtentionLicence(candidat.getAnneeObtentionLicence());
        dto.setMentionLicence(candidat.getMentionLicence());
        dto.setMoyenneLicence(candidat.getMoyenneLicence());

        // Master
        dto.setNomUniversiteMaster(candidat.getNomUniversiteMaster());
        dto.setPaysMaster(candidat.getPaysMaster());
        dto.setStatutMaster(candidat.getStatutMaster()); // Include statutMaster
        dto.setSpecialiteMaster(candidat.getSpecialiteMaster());
        dto.setAnneeObtentionMaster(candidat.getAnneeObtentionMaster());
        dto.setMentionMaster(candidat.getMentionMaster());
        dto.setMoyenneMaster(candidat.getMoyenneMaster());

        // Expérience professionnelle
        dto.setExperienceProfessionnelle(candidat.isExperienceProfessionnelle());
        dto.setOrganisme(candidat.getOrganismes());
        dto.setLangues(splitString(candidat.getLangues()));
        dto.setNiveauxLangues(splitString(candidat.getNiveauxLangues()));
        dto.setFonctions(splitString(candidat.getFonctions()));
        dto.setSecteurs(splitString(candidat.getSecteurs()));
        dto.setDuDates(splitString(candidat.getDuDates()));
        dto.setAuDates(splitString(candidat.getAuDates()));

        // Documents scannés
        dto.setBaccalaureatScanne(candidat.getBaccalaureatScanne());
        dto.setLicenceScanne(candidat.getLicenceScanne());
        dto.setMasterScanne(candidat.getMasterScanne());
        dto.setReleveNoteMasterScanne(candidat.getReleveNoteMasterScanne());
        dto.setReleveNoteLicenceScanne(candidat.getReleveNoteLicenceScanne());
        dto.setCarteNationaleScanne(candidat.getCarteNationaleScanne());
        dto.setCvScanne(candidat.getCvScanne());

        return dto;
    }

    @Override
    public Candidat toEntity(CandidatDTO dto) {
        Candidat candidat = new Candidat();

        candidat.setIdCandidate(dto.getIdCandidate());
        candidat.setDateNaissance(dto.getDateNaissance());
        candidat.setAdresse(dto.getAdresse());
        candidat.setCin(dto.getCin());
        candidat.setCne(dto.getCne());
        candidat.setPays(dto.getPays());
        candidat.setPhoto(dto.getPhoto());
        candidat.setFonctionnaire(dto.isFonctionnaire());
        candidat.setSituationFamiliale(dto.getSituationFamiliale());
        candidat.setNationalite(dto.getNationalite());
        candidat.setPaysNaissance(dto.getPaysNaissance());
        candidat.setProvinceNaissance(dto.getProvinceNaissance());
        candidat.setLieuNaissance(dto.getLieuNaissance());
        candidat.setSexe(dto.getSexe());
        candidat.setCodePostal(dto.getCodePostal());
        candidat.setEmailInstitutionnel(dto.getEmailInstitutionnel());
        candidat.setHandicape(dto.isHandicape());
        candidat.setProfessionPere(dto.getProfessionPere());
        candidat.setProfessionMere(dto.getProfessionMere());
        candidat.setCandidatProfession(dto.getCandidatProfession());
        candidat.setOrganismeEmployeur(dto.getOrganismeEmployeur());

        // Baccalauréat
        candidat.setNomLycee(dto.getNomLycee());
        candidat.setPaysBac(dto.getPaysBac());
        candidat.setProvinceBac(dto.getProvinceBac());
        candidat.setFiliereBac(dto.getFiliereBac());
        candidat.setAnneeObtentionBac(dto.getAnneeObtentionBac());
        candidat.setMentionBac(dto.getMentionBac());
        candidat.setMoyenneBac(dto.getMoyenneBac());

        // Licence
        candidat.setNomUniversiteLicence(dto.getNomUniversiteLicence());
        candidat.setPaysLicence(dto.getPaysLicence());
        candidat.setSpecialiteLicence(dto.getSpecialiteLicence());
        candidat.setAnneeObtentionLicence(dto.getAnneeObtentionLicence());
        candidat.setMentionLicence(dto.getMentionLicence());
        candidat.setMoyenneLicence(dto.getMoyenneLicence());

        // Master
        candidat.setNomUniversiteMaster(dto.getNomUniversiteMaster());
        candidat.setPaysMaster(dto.getPaysMaster());
        candidat.setStatutMaster(dto.getStatutMaster());
        candidat.setSpecialiteMaster(dto.getSpecialiteMaster());
        candidat.setAnneeObtentionMaster(dto.getAnneeObtentionMaster());
        candidat.setMentionMaster(dto.getMentionMaster());
        candidat.setMoyenneMaster(dto.getMoyenneMaster());

        // Transform List to String for multi-valued fields
        candidat.setLangues(joinList(dto.getLangues()));
        candidat.setNiveauxLangues(joinList(dto.getNiveauxLangues()));
        candidat.setOrganismes((dto.getOrganisme()));
        candidat.setFonctions(joinList(dto.getFonctions()));
        candidat.setSecteurs(joinList(dto.getSecteurs()));
        candidat.setDuDates(joinList(dto.getDuDates()));
        candidat.setAuDates(joinList(dto.getAuDates()));

        // Documents scannés
        candidat.setBaccalaureatScanne(dto.getBaccalaureatScanne());
        candidat.setLicenceScanne(dto.getLicenceScanne());
        candidat.setMasterScanne(dto.getMasterScanne());
        candidat.setReleveNoteMasterScanne(dto.getReleveNoteMasterScanne());
        candidat.setReleveNoteLicenceScanne(dto.getReleveNoteLicenceScanne());
        candidat.setCarteNationaleScanne(dto.getCarteNationaleScanne());
        candidat.setCvScanne(dto.getCvScanne());

        // Expérience professionnelle
        candidat.setExperienceProfessionnelle(dto.isExperienceProfessionnelle());

        return candidat;
    }


    private List<String> splitString(String input) {
        return input != null ? Arrays.asList(input.split(",")) : null;
    }

    private String joinList(List<String> input) {
        return input != null ? String.join(",", input) : null;
    }
}