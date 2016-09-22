package com.intive.snooker.ui;

import com.intive.snooker.api.request.CreateTournamentRequest;
import com.intive.snooker.api.response.ListTournamentsResponse;
import com.intive.snooker.api.TournamentManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Year;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */

@RestController
@RequestMapping("/tournament")
@AllArgsConstructor
public class TournamentsController {

    private TournamentManager tournamentManager;

    @PutMapping
    public void createTournament(@RequestBody CreateTournamentRequest request){
        tournamentManager.createTournament(request);
    }

    @GetMapping
    public ListTournamentsResponse getTournamentsByYear(String year){
        return tournamentManager.getTournamentByYear(Year.parse(year));
    }


}
