package com.PhD_UAE.PhD.Service;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Repository.UserRepository;
import com.PhD_UAE.PhD.Transformer.UserTransformer;
import com.PhD_UAE.PhD.Config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserTransformer userTransformer;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          UserTransformer userTransformer, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userTransformer = userTransformer;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user -> {
                    List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getUserType().name()));
                    return new org.springframework.security.core.userdetails.User(
                            user.getEmail(),
                            user.getMdp(),
                            authorities
                    );
                })
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    public ResponseEntity<Map<String, String>> login(UserDTO userDTO) {
        try {
            UserDetails userDetails = loadUserByUsername(userDTO.getEmail());
            User user = userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() ->
                    new UsernameNotFoundException("User not found"));

            if (passwordEncoder.matches(userDTO.getMdp(), userDetails.getPassword())) {
                String token = jwtUtil.generateToken(userDetails.getUsername(), user.getIdUser(), user.getUserType().name());
                return ResponseEntity.ok(Map.of("status", "success", "token", token));
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "User not found"));
        }
        return ResponseEntity.status(401).body(Map.of("status", "error", "message", "Login failed"));
    }

    public ResponseEntity<String> registerUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: User with email already exists!");
        }
        userDTO.setMdp(passwordEncoder.encode(userDTO.getMdp()));
        User user = userTransformer.toEntity(userDTO);
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userTransformer::toDTO)
                .collect(Collectors.toList());
    }

    public List<User> findAllByUserType(UserType userType) {
        return userRepository.findAllByUserType(userType);
    }

    public String updateUser(UserDTO userDTO) {
        Optional<User> userOpt = userRepository.findByEmail(userDTO.getEmail());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPrenom(userDTO.getPrenom());
            user.setNom(userDTO.getNom());
            user.setTel(userDTO.getTel());
            user.setUserType(userDTO.getUserType());

            // Only update password if provided
            if (userDTO.getMdp() != null && !userDTO.getMdp().isEmpty()) {
                user.setMdp(passwordEncoder.encode(userDTO.getMdp())); // Ensure password is encoded
            }

            userRepository.save(user);
            return "User updated successfully";
        } else {
            return "User not found.";
        }
    }

    public Optional<UserDTO> getUserById(long idUser) {
        return userRepository.findById(idUser).map(userTransformer::toDTO);
    }

    public boolean isCurrentUserCED() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_CED"));
    }
}
