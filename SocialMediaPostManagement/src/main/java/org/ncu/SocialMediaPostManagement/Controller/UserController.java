package org.ncu.SocialMediaPostManagement.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ncu.SocialMediaPostManagement.Entity.User;
import org.ncu.SocialMediaPostManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "Operations related to User Management")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Create a new user", description = "Registers a new user with email and password.")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        int userId = userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully with ID: " + userId);
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Allows a user to log in with email and password.")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        boolean isValid = userService.loginUser(user.getEmail(), user.getPassword());
        return isValid ? ResponseEntity.ok("Login successful") : ResponseEntity.status(401).body("Invalid credentials");
    }
}

