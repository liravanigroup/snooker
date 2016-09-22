package com.intive.snooker.domain;

import com.intive.snooker.api.response.ListTournamentsResponse;

import java.time.LocalDate;
import java.time.Year;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
public interface TournamentRepository {
    ListTournamentsResponse getTournamentByYear(Year tournamentYear);

    void save(Tournament tournament);

    Tournament load(LocalDate eventDate);
}
