package com.example.sqlvulnerableapp.repo;

import java.util.List;
public interface UserRepositoryCustom {
    List<UserEntity> findUsersByNameSafe(String name);

    String getEmail(String name);
}
