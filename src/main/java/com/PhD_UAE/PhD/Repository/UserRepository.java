package com.PhD_UAE.PhD.Repository;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // Change Integer to Long
    Optional<User> findByEmail(String email);
    List<User> findAllByUserType(UserType userType);
    Optional<User> findById(Long idUser); // This method should work now
}
