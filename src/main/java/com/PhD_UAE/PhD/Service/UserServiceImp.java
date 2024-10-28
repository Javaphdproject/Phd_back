package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Repository.UserRepository;
import com.PhD_UAE.PhD.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserTransformer userTransformer;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getUserType().name()));

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getMdp(),
                    authorities
            );
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

    public String login(UserDTO userDTO) {
        UserDetails userDetails;
        try {
            userDetails = loadUserByUsername(userDTO.getEmail());
        } catch (UsernameNotFoundException e) {
            return "{\"status\": \"error\", \"message\": \"User not found\"}";
        }

        if (userDetails != null) {
            if (passwordEncoder.matches(userDTO.getMdp(), userDetails.getPassword())) {
                String role = ((org.springframework.security.core.userdetails.User) userDetails)
                        .getAuthorities().iterator().next().getAuthority();
                return "{\"status\": \"success\", \"role\": \"" + role + "\"}";
            } else {
                return "{\"status\": \"error\", \"message\": \"Invalid password\"}";
            }
        }
        return "{\"status\": \"error\", \"message\": \"Login failed\"}";
    }

    public String registerUser(UserDTO userDTO) {
        System.out.println("Registering user with email: " + userDTO.getEmail());
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            return "Error: User with email already exists!";
        }
        userDTO.setMdp(passwordEncoder.encode(userDTO.getMdp()));
        System.out.println("Encrypted password: " + userDTO.getMdp());
        User user = userTransformer.toEntity(userDTO);
        userRepository.save(user);
        System.out.println("User saved successfully");
        return "User registered successfully!";
    }
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userTransformer::toDTO)
                .collect(Collectors.toList());
    }
    public List<User> findAllByUserType(UserType userType) {
        return userRepository.findAllByUserType(userType);
    }
    // In UserServiceImp.java
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

}

