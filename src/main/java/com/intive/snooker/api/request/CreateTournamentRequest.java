package com.intive.snooker.api.request;

import com.intive.snooker.api.dto.TournamentDto;
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
public class CreateTournamentRequest {

    private TournamentDto tournament;

    public void validate(){
        tournament.validate();
    }
}
