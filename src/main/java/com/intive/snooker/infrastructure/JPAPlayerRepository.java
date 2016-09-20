package com.intive.snooker.infrastructure;

import com.intive.snooker.domain.Player;
import com.intive.snooker.domain.PlayerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Repository
public class JPAPlayerRepository implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }
}
