package com.intive.snooker.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class MatchDto {
    private Long firstPlayerId;
    private Long secondPlayerId;
    private Collection<PartyDto> parties;
}
