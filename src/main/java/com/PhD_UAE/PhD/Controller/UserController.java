package com.PhD_UAE.PhD.Controller;

import com.PhD_UAE.PhD.Dto.UserDTO;
import com.PhD_UAE.PhD.Entity.User;
import com.PhD_UAE.PhD.Entity.UserType;
import com.PhD_UAE.PhD.Service.UserServiceImp;
import com.PhD_UAE.PhD.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/phd/auth/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private UserTransformer userTransformer;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        String result = String.valueOf(userService.registerUser(userDTO));
        if (result.contains("Error")) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO loginRequest) {
        String jwt = String.valueOf(userService.login(loginRequest));
        if (jwt.contains("error")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jwt);
        }
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{userType}")
    public ResponseEntity<List<UserDTO>> getUsersByUserType(@PathVariable UserType userType) {
        List<User> users = userService.findAllByUserType(userType);
        List<UserDTO> userDTOs = users.stream()
                .map(userTransformer::toDTO)
                .toList();
        return ResponseEntity.ok(userDTOs);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editUser(@RequestBody UserDTO userDTO) {
        String result = userService.updateUser(userDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getuser/{idUser}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long idUser) {
        Optional<UserDTO> userDTO = userService.getUserById(idUser);
        return userDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
