package com.intive.snooker.api.response;

import com.intive.snooker.domain.Round;
import com.intive.snooker.domain.Tournament;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */

@Getter
@Setter
@AllArgsConstructor
public class TournamentDtoResponse {


    private LocalDate tournamentDate;
    private Collection<Round> rounds;

    public TournamentDtoResponse(Tournament tournament) {
        this.tournamentDate = tournament.getDate();
        this.rounds = tournament.getRounds();
    }
}
