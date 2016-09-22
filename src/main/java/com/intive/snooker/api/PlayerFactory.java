package com.intive.snooker.api;

import com.intive.snooker.api.dto.PlayerDto;
import com.intive.snooker.api.request.CreatePlayerRequest;
import com.intive.snooker.domain.Player;
import org.springframework.stereotype.Service;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Service
public class PlayerFactory {

    public Player createPlayer(CreatePlayerRequest request) {
        PlayerDto player = request.getPlayer();
        return new Player(player);
    }
}
