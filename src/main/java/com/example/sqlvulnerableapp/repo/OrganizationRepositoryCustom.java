package com.example.sqlvulnerableapp.repo;

import java.util.List;

public interface OrganizationRepositoryCustom {
    List<UserEntity> findUsersByOrganizationNameUnsafe(String name);

    String findEmailByOrganizationNameUnsafe(String name);
}
