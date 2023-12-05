package com.example.sqlvulnerableapp.repo;

import java.util.List;
public interface UserRepositoryCustom {
    List<UserEntity> findUsersByNameSafe(String name);
    List<UserEntity> findUsersByNameUnsafe(String name);

}
