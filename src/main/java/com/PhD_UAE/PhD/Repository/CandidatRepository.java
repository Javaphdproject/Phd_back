package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    Optional<Candidat> findByUser_Email(String email);
    Optional<Candidat> findByIdCandidate(Long idCandidate);
    @Query("SELECT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser), " +
            "new com.PhD_UAE.PhD.Dto.SujetDTO(s.idSujet, s.titre, s.professeur.idProfesseur), " +
            "new com.PhD_UAE.PhD.Dto.CandidatDTO(c.idCandidate) " +
            "FROM User u " +
            "JOIN u.candidat c " +
            "JOIN c.candidature cu " +
            "JOIN cu.sujet s " +
            "JOIN s.professeur p " +
            "WHERE cu.etatCandidature = 'accepted' AND p.user.idUser = :idUser")
    List<Object[]> findAcceptedCandidates(@Param("idUser") long idUser);

    @Query("SELECT c.idCandidate FROM Candidat c WHERE c.user.idUser = :idUser")
    Long findIdCandidatByUserId(@Param("idUser") Long idUser);
    @Query("SELECT DISTINCT new com.PhD_UAE.PhD.Dto.UserDTO(u.nom, u.prenom, u.email, u.idUser) " +
            "FROM User u JOIN Candidat c ON u.candidat.idCandidate = c.idCandidate " +
            "WHERE c.idCandidate = :idCandidat")
    UserDTO findUserInfo(@Param("idCandidat") Long idCandidat);
}