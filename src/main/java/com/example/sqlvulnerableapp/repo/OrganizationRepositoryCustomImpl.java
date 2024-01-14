package com.example.sqlvulnerableapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizationRepositoryCustomImpl implements OrganizationRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findUsersByOrganizationNameUnsafe(String name) {
        String jpql = "SELECT u FROM Organization o JOIN UserEntity u on u.organization = o WHERE o.name ='" + name + "'";
        TypedQuery<UserEntity> query = entityManager.createQuery(jpql, UserEntity.class);
        return query.getResultList();
    }

    @Override
    public String findEmailByOrganizationNameUnsafeForAI(String name) {
        String jpql = "SELECT u.email FROM UserEntity u WHERE u.name ='" + name + "' and u.organization.id = 1";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        return query.getResultStream().collect(Collectors.joining(", "));
    }

    @Override
    public String findEmailByOrganizationNameSafeEngineering(String name) {
        String jpql = "SELECT u.email FROM UserEntity u WHERE u.name = :name and u.organization.id = 2";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("name", name);
        return query.getResultStream().collect(Collectors.joining(", "));
    }
}
