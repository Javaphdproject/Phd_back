package com.PhD_UAE.PhD.Transformer;

import com.PhD_UAE.PhD.Dto.CandidatDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.stereotype.Component;

@Component
public class CandidatTransformer extends Transformer<Candidat, CandidatDTO> {

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
        candidat.setCandidatprofession(dto.getCandidatprofession());
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

        // Langues
        candidat.setLangues(dto.getLangues());
        candidat.setNiveauxLangues(dto.getNiveauxLangues());

        // Expérience professionnelle
        candidat.setExperienceProfessionnelle(dto.isExperienceProfessionnelle());
        candidat.setOrganisme(dto.getOrganisme());
        candidat.setFonctions(dto.getFonctions());
        candidat.setSecteurs(dto.getSecteurs());
        candidat.setDuDates(dto.getDuDates());
        candidat.setAuDates(dto.getAuDates());

        // Documents scannés
        candidat.setBaccalaureatScanne(dto.getBaccalaureatScanne());
        candidat.setLicenceScanne(dto.getLicenceScanne());
        candidat.setMasterScanne(dto.getMasterScanne());
        candidat.setReleveNoteMasterScanne(dto.getReleveNoteMasterScanne());
        candidat.setReleveNoteLicenceScanne(dto.getReleveNoteLicenceScanne());
        candidat.setCarteNationaleScanne(dto.getCarteNationaleScanne());
        candidat.setCvScanne(dto.getCvScanne());

        return candidat;
    }

    @Override
    public CandidatDTO toDTO(Candidat entity) {
        CandidatDTO dto = new CandidatDTO();
        dto.setIdCandidate(entity.getIdCandidate());
        dto.setDateNaissance(entity.getDateNaissance());
        dto.setAdresse(entity.getAdresse());
        dto.setCin(entity.getCin());
        dto.setCne(entity.getCne());
        dto.setPays(entity.getPays());
        dto.setPhoto(entity.getPhoto());
        dto.setFonctionnaire(entity.isFonctionnaire());
        dto.setSituationFamiliale(entity.getSituationFamiliale());
        dto.setNationalite(entity.getNationalite());
        dto.setPaysNaissance(entity.getPaysNaissance());
        dto.setProvinceNaissance(entity.getProvinceNaissance());
        dto.setLieuNaissance(entity.getLieuNaissance());
        dto.setSexe(entity.getSexe());
        dto.setCodePostal(entity.getCodePostal());
        dto.setEmailInstitutionnel(entity.getEmailInstitutionnel());
        dto.setHandicape(entity.isHandicape());
        dto.setProfessionPere(entity.getProfessionPere());
        dto.setProfessionMere(entity.getProfessionMere());
        dto.setCandidatprofession(entity.getCandidatprofession());
        dto.setOrganismeEmployeur(entity.getOrganismeEmployeur());

        // Baccalauréat
        dto.setNomLycee(entity.getNomLycee());
        dto.setPaysBac(entity.getPaysBac());
        dto.setProvinceBac(entity.getProvinceBac());
        dto.setFiliereBac(entity.getFiliereBac());
        dto.setAnneeObtentionBac(entity.getAnneeObtentionBac());
        dto.setMentionBac(entity.getMentionBac());
        dto.setMoyenneBac(entity.getMoyenneBac());

        // Licence
        dto.setNomUniversiteLicence(entity.getNomUniversiteLicence());
        dto.setPaysLicence(entity.getPaysLicence());
        dto.setSpecialiteLicence(entity.getSpecialiteLicence());
        dto.setAnneeObtentionLicence(entity.getAnneeObtentionLicence());
        dto.setMentionLicence(entity.getMentionLicence());
        dto.setMoyenneLicence(entity.getMoyenneLicence());

        // Master
        dto.setNomUniversiteMaster(entity.getNomUniversiteMaster());
        dto.setPaysMaster(entity.getPaysMaster());
        dto.setStatutMaster(entity.getStatutMaster());
        dto.setSpecialiteMaster(entity.getSpecialiteMaster());
        dto.setAnneeObtentionMaster(entity.getAnneeObtentionMaster());
        dto.setMentionMaster(entity.getMentionMaster());
        dto.setMoyenneMaster(entity.getMoyenneMaster());

        // Langues
        dto.setLangues(entity.getLangues());
        dto.setNiveauxLangues(entity.getNiveauxLangues());

        // Expérience professionnelle
        dto.setExperienceProfessionnelle(entity.isExperienceProfessionnelle());
        dto.setOrganisme(entity.getOrganisme());
        dto.setFonctions(entity.getFonctions());
        dto.setSecteurs(entity.getSecteurs());
        dto.setDuDates(entity.getDuDates());
        dto.setAuDates(entity.getAuDates());

        // Documents scannés
        dto.setBaccalaureatScanne(entity.getBaccalaureatScanne());
        dto.setLicenceScanne(entity.getLicenceScanne());
        dto.setMasterScanne(entity.getMasterScanne());
        dto.setReleveNoteMasterScanne(entity.getReleveNoteMasterScanne());
        dto.setReleveNoteLicenceScanne(entity.getReleveNoteLicenceScanne());
        dto.setCarteNationaleScanne(entity.getCarteNationaleScanne());
        dto.setCvScanne(entity.getCvScanne());

        return dto;
    }
}
