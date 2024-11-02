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
        // Vérifier si l'établissement existe
        Etablissement etablissement = etablissementRepository.findById(etablissementId)
                .orElseThrow(() -> new RuntimeException("Etablissement not found"));

        // Vérifier si une structure de recherche avec le même nom existe déjà dans le même établissement
        boolean existsInSameEtablissement = structureRechercheRepository.findAllByEtablissement_IdEtablissement(etablissementId)
                .stream()
                .anyMatch(structure -> structure.getNom().equalsIgnoreCase(structureRechercheDTO.getNom()));

        if (existsInSameEtablissement) {
            return "Cette structure de recherche existe déjà pour cet établissement.";
        }

        // Vérifier si une structure de recherche avec le même nom existe dans un autre établissement
        boolean existsInOtherEtablissement = structureRechercheRepository.existsByTypeStructureAndNom(
                structureRechercheDTO.getTypeStructure(), structureRechercheDTO.getNom());

        if (existsInOtherEtablissement) {
            return "Cette structure de recherche existe déjà dans un autre établissement.";
        }

        // Créer une nouvelle structure de recherche
        StructureRecherche structureRecherche = new StructureRecherche();
        structureRecherche.setTypeStructure(structureRechercheDTO.getTypeStructure());
        structureRecherche.setNom(structureRechercheDTO.getNom());
        structureRecherche.setEtablissement(etablissement);

        structureRechercheRepository.save(structureRecherche);

        return "Structure de recherche créée avec succès!";
    }
}
