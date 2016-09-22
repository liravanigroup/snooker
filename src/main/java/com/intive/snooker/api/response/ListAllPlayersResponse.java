package com.intive.snooker.api.response;

import com.intive.snooker.api.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ListAllPlayersResponse {
    private Collection<PlayerDto> players;
}
