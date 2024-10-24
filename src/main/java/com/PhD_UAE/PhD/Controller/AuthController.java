package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager; // Gère l'authentification des utilisateurs via Spring Security

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Check if the email already exists
        if (userService.emailExists(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists: " + user.getEmail());
        }
        // Save the user
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.convertToDTO(user));
    }
   /* @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Essayez d'authentifier avec les informations d'identification fournies
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getMdp())
            );
            // Mettez l'authentification dans le SecurityContext si c'est réussi
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Récupérez l'utilisateur de la base de données
            User authenticatedUser = userService.findByEmail(user.getEmail());
            // Vérifiez si le type d'utilisateur correspond à celui attendu
            if (!authenticatedUser.getUserType().equals(user.getUserType())) {
                response.put("message", "Login failed: User type does not match.");
                return response;
            }

            // Convertir User en UserDTO
            UserDTO userDTO = userService.convertToDTO(authenticatedUser);
            // Créer une réponse avec un message de succès et le UserDTO
            response.put("message", "User " + userDTO.getPrenom() + " logged in successfully as " + userDTO.getUserType());
            response.put("user", userDTO);

            // Générez un token simple
            String token = generateToken(authenticatedUser.getIdUser());
            response.put("token", token); // Ajouter le token à la réponse
        } catch (BadCredentialsException e) {
            // Gérer les informations d'identification incorrectes
            response.put("message", "Login failed: Incorrect username or password");
        } catch (Exception e) {
            // Gérer les autres exceptions
            response.put("message", "Login failed: An error occurred during authentication");
        }

        return response;
    }*/

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Try to authenticate with the provided credentials
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getMdp())
            );
            // Set the authentication in the SecurityContext if successful
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Fetch the user from the database
            User authenticatedUser = userService.findByEmail(user.getEmail());
            if (!authenticatedUser.getUserType().equals(user.getUserType())) {
                response.put("message", "Login failed: User type does not match.");
                return response;
            }
            // Convert User to UserDTO
            UserDTO userDTO = userService.convertToDTO(authenticatedUser);
            // Create a response with both a success message and the UserDTO
            response.put("message", "User " + userDTO.getPrenom() + " logged in successfully as " + userDTO.getUserType());
            response.put("user", userDTO);
        } catch (BadCredentialsException e) {
            // Handle incorrect credentials
            response.put("message", "Login failed: Incorrect username or password");
        } catch (Exception e) {
            // Handle other exceptions
            response.put("message", "Login failed: An error occurred during authentication");
        }

        return response;
    }
    /*@PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getMdp())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User authenticatedUser = userService.findByEmail(user.getEmail());
            UserDTO userDTO = userService.convertToDTO(authenticatedUser);

            // Générez un token simple
            String token = generateToken(authenticatedUser.getIdUser());

            response.put("message", "User " + userDTO.getPrenom() + " logged in successfully.");
            response.put("user", userDTO);
            response.put("token", token); // Ajouter le token à la réponse
        } catch (BadCredentialsException e) {
            response.put("message", "Login failed: Incorrect username or password");
        } catch (Exception e) {
            response.put("message", "Login failed: An error occurred during authentication");
        }

        return response;
    }*/
   @GetMapping("/users/{userType}")
   public List<UserDTO> getUsersByType(@PathVariable UserType userType) {
       // Fetch and return all users of the specified type without authentication
       List<User> users = userService.findAllByUserType(userType);
       return users.stream()
               .map(userService::convertToDTO)
               .toList();
   }
    // Méthode pour générer un token simple
    private String generateToken(Long userId) {
        return userId + ":" + System.currentTimeMillis();
    }
}
