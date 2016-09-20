package com.intive.snooker.api;

import com.intive.snooker.domain.Player;
import com.intive.snooker.domain.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Service
@AllArgsConstructor
public class PlayerManager {

    private PlayerRepository playerRepository;
    private PlayerFactory playerFactory;

    @Transactional
    public void createPlayer(CreatePlayerRequest request) {
        Player newPlayer = playerFactory.createPlayer(request);
        playerRepository.save(newPlayer);
    }
}
