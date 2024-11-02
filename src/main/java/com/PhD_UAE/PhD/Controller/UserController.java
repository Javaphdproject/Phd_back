package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Service.UserServiceImp;
import com.PhD_UAE.PhD.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users")
public class UserController {
    @Autowired
    private UserTransformer userTransformer;

    @Autowired
    private UserServiceImp userService;

    @PostMapping("/register")
    public String inscription(@RequestBody UserDTO userDTO) {
        System.out.println("Role : " + userDTO.getUserType());
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO loginRequest) {
        return userService.login(loginRequest);
    }
    @GetMapping("/getall")
    public List<UserDTO> getAll() {
        return userService.getAllUsers(); // Call the service method to get all users
    }
    @GetMapping("/users/{userType}")
    public List<UserDTO> getUsersByUserType(@PathVariable UserType userType) {
        List<User> users = userService.findAllByUserType(userType);
        return users.stream()
                .map(userTransformer::toDTO)
                .toList();
    }
    @PutMapping("/edit")
    public ResponseEntity<String> edit(@RequestBody UserDTO userDTO) {
        String result = userService.updateUser(userDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getuser/{idUser}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long idUser) {
        Optional<UserDTO> user = userService.getUserById(idUser);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

