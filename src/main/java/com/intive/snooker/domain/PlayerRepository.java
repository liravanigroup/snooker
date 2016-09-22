package com.intive.snooker.domain;

import com.intive.snooker.api.dto.PlayerDto;

import java.util.List;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
public interface PlayerRepository {
    void save(Player player);

    Player load(String firstName, String secondName);

    Player load(Long playerId);

    void delete(Long playerId);

    List<Player> getAllPlayers();
}
