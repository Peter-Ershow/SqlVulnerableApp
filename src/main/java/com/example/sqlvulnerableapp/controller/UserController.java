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

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userService.addUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //safe queries

    @GetMapping("/{name}/email")
    public ResponseEntity<String> getUserEmailByNameSafe(@PathVariable String name) {
        return ResponseEntity.ok(userService.getEmail(name));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<UserEntity>> getUserByNameSafe(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUsersByNameSafe(name));
    }
}
