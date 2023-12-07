package com.example.sqlvulnerableapp.service;

import com.example.sqlvulnerableapp.repo.UserEntity;
import com.example.sqlvulnerableapp.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> updateUser(Long id, UserEntity userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setEmail(userDetails.getEmail());
                    return userRepository.save(user);
                });
    }

    public boolean deleteUser(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }

    public List<UserEntity> getUsersByNameSafe(String name) {
        return userRepository.findUsersByNameSafe(name);
    }

    public String getEmail(String name) {
        return userRepository.getEmail(name);
    }

}
