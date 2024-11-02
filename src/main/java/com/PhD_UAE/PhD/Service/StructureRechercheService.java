
package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.StructureRechercheDTO;
import com.PhD_UAE.PhD.Entity.Etablissement;
import com.PhD_UAE.PhD.Entity.StructureRecherche;
import com.PhD_UAE.PhD.Repository.EtablissementRepository;
import com.PhD_UAE.PhD.Repository.StructureRechercheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StructureRechercheService {

    @Autowired
    private StructureRechercheRepository structureRechercheRepository;

    @Autowired
    private EtablissementRepository etablissementRepository;

    @Transactional
    public String createStructureRecherche(Long etablissementId, StructureRechercheDTO structureRechercheDTO) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId)
                .orElseThrow(() -> new RuntimeException("Etablissement not found"));

        StructureRecherche structureRecherche = new StructureRecherche();
        structureRecherche.setTypeStructure(structureRechercheDTO.getTypeStructure());
        structureRecherche.setNom(structureRechercheDTO.getNom());
        structureRecherche.setEtablissement(etablissement);

        structureRechercheRepository.save(structureRecherche);

        return "Structure de recherche created successfully!";
    }
}
