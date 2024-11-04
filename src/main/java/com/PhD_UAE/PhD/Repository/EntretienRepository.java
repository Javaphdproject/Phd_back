package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Dto.EntretienDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import com.PhD_UAE.PhD.Entity.Entretien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntretienRepository extends CrudRepository<Entretien, Integer> {

    @Query("SELECT e.candidat FROM Entretien e WHERE e.status = 'accepted'")
    List<Candidat> findAcceptedCandidates();


    List<Entretien> findByStatus(String status);
    @Query("SELECT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser), " +
            "new com.PhD_UAE.PhD.Dto.SujetDTO(s.idSujet, s.titre, s.professeur.idProfesseur), " +
            "new com.PhD_UAE.PhD.Dto.EntretienDTO(e.idEntretien, e.candidat.idCandidate) " +
            "FROM User u " +
            "JOIN Candidat c ON u.idUser = c.user.idUser " +
            "JOIN Candidature cu ON c.idCandidate = cu.candidate.idCandidate " +
            "JOIN Sujet s ON cu.sujet.idSujet = s.idSujet " +
            "JOIN Entretien e ON e.candidat.idCandidate = c.idCandidate " +
            "WHERE e.professeur.idProfesseur = :professorId AND e.status = 'Accepted'")
    List<Object[]> findCandidateInfoByProfessorId(@Param("professorId") Long professorId);
    @Query("SELECT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser), " +
            "new com.PhD_UAE.PhD.Dto.SujetDTO(s.idSujet, s.titre, s.professeur.idProfesseur), " +
            "new com.PhD_UAE.PhD.Dto.EntretienDTO(e.idEntretien) " +
            "FROM User u " +
            "JOIN Candidat c ON u.idUser = c.user.idUser " +
            "JOIN Candidature cu ON c.idCandidate = cu.candidate.idCandidate " +
            "JOIN Sujet s ON cu.sujet.idSujet = s.idSujet " +
            "JOIN Entretien e ON e.candidat.idCandidate = c.idCandidate " +
            "WHERE e.professeur.idProfesseur = :professorId AND e.status = 'doctorant'")
    List<Object[]> findDoctorantInfoByProfessorId(@Param("professorId") Long professorId);
    Entretien findByIdEntretien(Long idEntretien);
    @Query("SELECT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser), " +
            "new com.PhD_UAE.PhD.Dto.SujetDTO(s.idSujet, s.titre, s.professeur.idProfesseur), " +
            "new com.PhD_UAE.PhD.Dto.StructureRechercheDTO(str.typeStructure, str.nom), " +
            "new com.PhD_UAE.PhD.Dto.EtablissmentDTO(etab.idEtablissement, etab.adresseEtablissement, etab.nomEtablissement, etab.ville), " +
            "new com.PhD_UAE.PhD.Dto.EntretienDTO(e.idEntretien, e.resultat, e.date), " +
            "new com.PhD_UAE.PhD.Dto.UserDTO(p.nom, p.prenom, p.email, p.idUser) " + // Adding professor details
            "FROM User u " +
            "JOIN Candidat c ON u.idUser = c.user.idUser " +
            "JOIN Candidature cu ON c.idCandidate = cu.candidate.idCandidate " +
            "JOIN Sujet s ON cu.sujet.idSujet = s.idSujet " +
            "JOIN Entretien e ON e.candidat.idCandidate = c.idCandidate " +
            "JOIN Etablissement etab ON e.professeur.etablissement.idEtablissement = etab.idEtablissement " +
            "JOIN StructureRecherche str ON str.etablissement.idEtablissement = etab.idEtablissement " +
            "JOIN User p ON e.professeur.user.idUser = p.idUser " + // Join with User table for professor
            "WHERE e.professeur.idProfesseur = :professorId " +
            "AND e.status = 'doctorant' " +
            "AND e.idEntretien = :identretien")

    List<Object[]> findDoctorantInfoByProfessorId(@Param("professorId") Long professorId, @Param("identretien") Long identretien);
    @Query(value = "SELECT DATE(e.date) AS interviewDate, COUNT(*) AS interviewCount " +
            "FROM entretien e " +
            "WHERE e.professeur.idProfesseur = :professorId " +
            "GROUP BY interviewDate " +
            "ORDER BY interviewDate",
            nativeQuery = true)
    List<EntretienDTO> countInterviewsByDate(@Param("professorId") Long professorId);


}
