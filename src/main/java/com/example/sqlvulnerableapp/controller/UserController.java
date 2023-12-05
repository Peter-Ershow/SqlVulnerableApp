package com.example.sqlvulnerableapp.controller;

import com.example.sqlvulnerableapp.repo.UserEntity;
import com.example.sqlvulnerableapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/testSafe/{name}")
    public ResponseEntity<List<UserEntity>> getUsersByNameSafe(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUsersByNameSafe(name));
    }
    @GetMapping("/testWrong/{name}")
    public ResponseEntity<List<UserEntity>> getUsersByNameUnsafe(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUsersByNameUnsafe(name));
    }

    // Update a user
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
