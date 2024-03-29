package com.example.sqlvulnerableapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findUsersByNameSafe(String name) {
        String jpql = "SELECT u FROM UserEntity u WHERE u.name = :name";
        TypedQuery<UserEntity> query = entityManager.createQuery(jpql, UserEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public String getEmail(String name) {
        String jpql = "SELECT u.email FROM UserEntity u WHERE u.name = :name";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("name", name);
        return query.getResultStream().collect(Collectors.joining(", "));
    }
}
