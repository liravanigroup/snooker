package com.intive.snooker.infrastructure;

import com.intive.snooker.api.InvalidRequestException;
import com.intive.snooker.api.response.ListAllPlayersResponse;
import com.intive.snooker.api.dto.PlayerDto;
import com.intive.snooker.domain.Player;
import com.intive.snooker.domain.PlayerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

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

    @Override
    public Player load(String firstName, String secondName) {
        checkNotNull(firstName);
        checkNotNull(secondName);
        List<Player> players = entityManager.createQuery("FROM Player p WHERE p.firstName=:firstName AND p.lastName=:lastName", Player.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", secondName)
                .getResultList();
        if(players.isEmpty())
            return null;
        return players.get(0);
    }

    @Override
    public Player load(Long playerId) {
        return entityManager.find(Player.class, playerId);
    }

    @Override
    public void delete(Long playerId) {
        Player player = load(playerId);
        validatePlayerId(player);
        entityManager.remove(player);
    }

    @Override
    public List<Player> getAllPlayers() {
         return entityManager.createQuery("FROM Player", Player.class).getResultList();
    }

    private void validatePlayerId(Player player) {
        if(player == null)
            throw new InvalidRequestException("Player is not exists");
    }
}
