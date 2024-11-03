package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.EtablissmentDTO;
import com.PhD_UAE.PhD.Dto.StructureRechercheDTO;
import com.PhD_UAE.PhD.Entity.CED;
import com.PhD_UAE.PhD.Entity.Etablissement;
import com.PhD_UAE.PhD.Repository.CedRepository;
import com.PhD_UAE.PhD.Repository.EtablissementRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private CedRepository cedRepository;
    @Transactional
    public String createEtablissement(Long cedId, EtablissmentDTO etablissementDTO) {
        CED ced = cedRepository.findById(cedId)
                .orElseThrow(() -> new RuntimeException("CED not found"));
        Etablissement etablissement = new Etablissement();
        etablissement.setNomEtablissement(etablissementDTO.getNomEtablissement());
        etablissement.setAdresseEtablissement(etablissementDTO.getAdresseEtablissement());
        etablissement.setVille(etablissementDTO.getVille());
        etablissement.setCed(ced);
        etablissementRepository.save(etablissement);
        return "Etablissement created successfully!";
    }
    private EtablissmentDTO convertToDTO(Etablissement etablissement) {
        EtablissmentDTO dto = new EtablissmentDTO();
        dto.setIdEtablissement(etablissement.getIdEtablissement());
        dto.setNomEtablissement(etablissement.getNomEtablissement());
        dto.setAdresseEtablissement(etablissement.getAdresseEtablissement());
        dto.setVille(etablissement.getVille());
        dto.setStructures(etablissement.getStructuresRecherche().stream()
                .map(StructureRechercheDTO::new)
                .collect(Collectors.toList()));
        return dto;
    }
    @Transactional
    public List<EtablissmentDTO> getAllEtablissementsWithStructures() {
        List<Etablissement> etablissements = etablissementRepository.findAll();
        etablissements.forEach(etablissement -> Hibernate.initialize(etablissement.getStructuresRecherche()));
        return etablissements.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

}