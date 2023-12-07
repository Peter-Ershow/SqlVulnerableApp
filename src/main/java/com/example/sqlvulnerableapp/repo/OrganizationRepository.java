package com.example.sqlvulnerableapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, OrganizationRepositoryCustom {
}

