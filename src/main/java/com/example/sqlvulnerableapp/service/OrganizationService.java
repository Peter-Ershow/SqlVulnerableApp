package com.example.sqlvulnerableapp.service;

import com.example.sqlvulnerableapp.repo.OrganizationRepository;
import com.example.sqlvulnerableapp.repo.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<UserEntity> getUsersByNameUnsafe(String name) {
        return organizationRepository.findUsersByOrganizationNameUnsafe(name);
    }

    public String getEmailsByNameUnsafeAI(String name) {
        return organizationRepository.findEmailByOrganizationNameUnsafeForAI(name);
    }

    public String getEmailsByNameSafeEngineering(String name) {
        return organizationRepository.findEmailByOrganizationNameSafeEngineering(name);
    }
}
