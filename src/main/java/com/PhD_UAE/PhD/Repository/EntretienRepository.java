package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.Entretien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntretienRepository extends CrudRepository<Entretien, Integer> {
    @Query("SELECT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser), " +
            "new com.PhD_UAE.PhD.Dto.SujetDTO(s.idSujet, s.titre, s.professeur.idProfesseur) " +
            "FROM User u " +
            "JOIN Candidat c ON u.idUser = c.user.idUser " +
            "JOIN Candidature cu ON c.idCandidate = cu.candidate.idCandidate " +
            "JOIN Sujet s ON cu.sujet.idSujet = s.idSujet " +
            "JOIN Entretien e ON e.candidat.idCandidate = c.idCandidate " +
            "WHERE e.professeur.idProfesseur = :professorId")
    List<Object[]> findCandidateInfoByProfessorId(Long professorId);
}
