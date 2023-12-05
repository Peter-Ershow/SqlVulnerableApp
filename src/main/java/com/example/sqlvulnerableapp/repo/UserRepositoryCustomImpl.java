package com.example.sqlvulnerableapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public List<UserEntity> findUsersByNameUnsafe(String name) {
        String jpql = "SELECT u FROM UserEntity u WHERE u.name = '" + name + "'";
        TypedQuery<UserEntity> query = entityManager.createQuery(jpql, UserEntity.class);
        return query.getResultList();
    }
}
