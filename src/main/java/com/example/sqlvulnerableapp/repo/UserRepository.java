package com.example.sqlvulnerableapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {

}

