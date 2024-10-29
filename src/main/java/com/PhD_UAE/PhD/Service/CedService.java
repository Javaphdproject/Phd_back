package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.*;
import com.PhD_UAE.PhD.Entity.*;
import com.PhD_UAE.PhD.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CedService {
    @Autowired
    private EtablissementRepository etablissementRepository ;

    @Autowired
    private StructureRechercheRepository structureRechercheRepository ;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CedRepository cedRepository;
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private UserRepository UserRepository;

    public List<EtablissmentDTO> getAllEtablissement(){
        List<Etablissement> etablissements = etablissementRepository.findAll();
        List<EtablissmentDTO> dto = etablissements.stream().map(EtablissmentDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }

    public List<CedDTO> getAllCed(){
        List<CED> ceds = cedRepository.findAll();
        List<CedDTO> dto = ceds.stream().map(CedDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }

    public List<EtablissmentDTO> getAllEtablissementByCED(Long idCED){
        List<Etablissement> etablissements = etablissementRepository.findAllByCed_IdCED(idCED);
        List<EtablissmentDTO> dto = etablissements.stream().map(EtablissmentDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }

    public List<StructureRechercheDTO> getAllStrByEtablissement(Long idEtablissement){
        List<StructureRecherche> structureRecherches = structureRechercheRepository.findAllByEtablissement_IdEtablissement(idEtablissement);
        List<StructureRechercheDTO> dto = structureRecherches.stream().map(StructureRechercheDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }

    public List<ProfesseurDTO> getProfBystr(Long idStr){
        List<Professeur> professeurs = professorRepository.findAllByStructureRecherche_IdSTr(idStr);
        List<ProfesseurDTO> dto = professeurs.stream().map(ProfesseurDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }


    @Transactional
    public void createProfesseur(ProfesseurDTO professeurDTO) {
        // Create and save User
        User user = new User();
        user.setPrenom(professeurDTO.getPrenom());
        user.setNom(professeurDTO.getNom());
        user.setEmail(professeurDTO.getEmail());
        user.setMdp(professeurDTO.getPassword());
        user.setTel(professeurDTO.getTel());
        user.setUserType(professeurDTO.getUserType());

        User savedUser = UserRepository.save(user);

        // Create and save Professeur
        Professeur professeur = new Professeur();
        professeur.setAdresse(professeurDTO.getAdresse());
        professeur.setGrade(professeurDTO.getGrade());
        professeur.setPassword(professeurDTO.getPassword());
        professeur.setUser(savedUser);

        professorRepository.save(professeur);
    }

    //candidature

    public List<CandidatureDTO> getAllCandidature(){
        List<Candidature> candidatures = candidatureRepository.findAll();
        List<CandidatureDTO> dto = candidatures.stream().map(CandidatureDTO::new)
                .collect(Collectors.toList());
        return  dto;
    }

    public CandidatureDTO getCandidatureByID(Long idCandidature){
        Candidature candidature = candidatureRepository.findCandidatureByIdcandidature(idCandidature);
        if (candidature == null){
            return  null;
        }
        return  new CandidatureDTO(candidature);
    }




 /*   public CandidatDTO getCandidatById(Long idCandidat){
        Candidat candidat = candidatRepository.findCandidatByIdCandidate(idCandidat);
        if (candidat == null){
            return  null;
        }
        return  new CandidatDTO(candidat);
    }*/

    public CandidatureDTO updateCandidatureStatus(Long idCandidature, String newStatus) {
        Candidature candidature = candidatureRepository.findCandidatureByIdcandidature(idCandidature);

        if (candidature == null) {
            return null;
        }
        candidature.setEtatCandidature(newStatus);
        candidatureRepository.save(candidature);
        return new CandidatureDTO(candidature);
    }


}
