package com.intive.snooker.api.request;

import com.intive.snooker.api.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class CreatePlayerRequest {
    private PlayerDto player;

    public void validate() {
        player.validate();
    }
}
