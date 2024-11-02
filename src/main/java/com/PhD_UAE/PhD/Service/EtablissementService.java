package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.EtablissmentDTO;
import com.PhD_UAE.PhD.Entity.CED;
import com.PhD_UAE.PhD.Entity.Etablissement;
import com.PhD_UAE.PhD.Repository.CedRepository;
import com.PhD_UAE.PhD.Repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
