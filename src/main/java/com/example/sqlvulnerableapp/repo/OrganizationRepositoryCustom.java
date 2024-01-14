package com.example.sqlvulnerableapp.repo;

import java.util.List;

public interface OrganizationRepositoryCustom {
    List<UserEntity> findUsersByOrganizationNameUnsafe(String name);

    String findEmailByOrganizationNameUnsafeForAI(String name);

    String findEmailByOrganizationNameSafeEngineering(String name);
}
