package com.intive.snooker.api.response;

import com.intive.snooker.api.dto.TournamentDto;
import com.intive.snooker.domain.Tournament;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class ListTournamentsResponse {

    private Collection<TournamentDtoResponse> tournaments;


}
