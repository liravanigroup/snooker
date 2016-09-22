package com.intive.snooker.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.intive.snooker.domain.Round;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TournamentDto {
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate eventDate;
    private RoundDto round;


    public void validate() {

    }

    public Collection<RoundDto> getRoundsList() {
        Collection<RoundDto> rounds = new LinkedList<>();
        round.addRound(rounds);
        return rounds;
    }
}
