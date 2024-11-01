package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.CED;
import com.PhD_UAE.PhD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CedRepository extends JpaRepository<CED, Long> {
    CED findByUser(User user); // Méthode pour trouver le CED par utilisateur

}
