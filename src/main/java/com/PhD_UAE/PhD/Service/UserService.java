package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save user
    public void saveUser(User user) {
        user.setMdp(passwordEncoder.encode(user.getMdp())); // Hash the password
        userRepository.save(user);
    }
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent(); // Adjust based on  UserRepository
    }
    // Find by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    // Convert User entity to UserDTO
    public UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getIdUser(), user.getPrenom(), user.getNom(), user.getEmail(), user.getUserType());
    }
    public List<User> findAllByUserType(UserType userType) {
        return userRepository.findAllByUserType(userType);
    }
}
