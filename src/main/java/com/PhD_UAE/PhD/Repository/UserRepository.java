package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
