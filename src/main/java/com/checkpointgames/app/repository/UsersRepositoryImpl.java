package com.checkpointgames.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsersRepositoryImpl implements UsersRepositoryCustom {    
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void updatePassword(Long id, String novaSenha) {
        entityManager.createQuery("UPDATE users u SET u.password = :senha WHERE u.id = :id")
                     .setParameter("password", novaSenha)
                     .setParameter("id", id)
                     .executeUpdate();
    }    
}

