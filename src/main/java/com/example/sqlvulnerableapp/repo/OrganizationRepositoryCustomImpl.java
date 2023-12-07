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
    public String findEmailByOrganizationNameUnsafe(String name) {
        String jpql = "SELECT u.email FROM Organization o JOIN UserEntity u on u.organization = o WHERE o.name ='" + name + "'";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        return query.getResultStream().collect(Collectors.joining(", "));
    }
}
