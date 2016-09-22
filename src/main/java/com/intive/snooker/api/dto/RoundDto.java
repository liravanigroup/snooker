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
public class RoundDto {
    private Collection<MatchDto> matches;
    private RoundDto round;

    public void addRound(Collection<RoundDto> rounds) {
        if (round == null) {
            rounds.add(this);
        } else {
            rounds.add(new RoundDto(matches, round));
            round.addRound(rounds);
        }
    }
}
