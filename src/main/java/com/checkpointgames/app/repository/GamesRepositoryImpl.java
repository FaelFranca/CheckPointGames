package com.checkpointgames.app.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GamesRepositoryImpl {
    
    @PersistenceContext
    private EntityManager entityManager;    
    

    public void updateGames(String name, String description, Integer inventory, BigDecimal value, Integer status, String linkImage, Integer id){
        entityManager.createQuery("UPDATE Games g set g.name = :name, g.description = :description, g.inventory= :inventory, g.value = :value, g.status = :status, g.linkImage= :linkImage where g.id = :id")
                     .setParameter("name", name)
                     .setParameter("description", description)
                     .setParameter("inventory", inventory)
                     .setParameter("value", value)
                     .setParameter("status", status)
                     .setParameter("linkImage", linkImage)
                     .setParameter("id", id)               
                     .executeUpdate();
    }
}