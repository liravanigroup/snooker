package com.intive.snooker.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlayersDto {
    private Long firstPlayerId;
    private Long secondPlayerId;

    public void validate() {
        validateFirstPlayerId(firstPlayerId);
        validateSecondPlayerId(secondPlayerId);
    }

    private void validateSecondPlayerId(Long secondPlayerId) {
        //TODO
    }

    private void validateFirstPlayerId(Long firstPlayerId) {
        //TODO
    }
}
