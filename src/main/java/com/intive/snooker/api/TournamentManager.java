package com.intive.snooker.api;

import com.intive.snooker.api.dto.TournamentDto;
import com.intive.snooker.api.request.CreateTournamentRequest;
import com.intive.snooker.api.response.ListTournamentsResponse;
import com.intive.snooker.domain.Tournament;
import com.intive.snooker.domain.TournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Year;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Service
@AllArgsConstructor
public class TournamentManager {

    private TournamentRepository tournamentRepository;
    private TournamentFactory tournamentFactory;

    public ListTournamentsResponse getTournamentByYear(Year tournamentYear) {
        return tournamentRepository.getTournamentByYear(tournamentYear);
    }

    @Transactional
    public void createTournament(CreateTournamentRequest request) {
        request.validate();
        validateDuplication(request);
        Tournament tournament = tournamentFactory.createTournament(request);
        tournamentRepository.save(tournament);
    }

    private void validateDuplication(CreateTournamentRequest request) {
        LocalDate dateOfNewTournament = getDateOfNewTournament(request);
        Tournament tournamentAtActualDate = tournamentRepository.load(dateOfNewTournament);
        if (tournamentAtActualDate != null)
            throw new InvalidRequestException("Tournament at " + dateOfNewTournament + " already exists");
    }

    private LocalDate getDateOfNewTournament(CreateTournamentRequest request) {
        return request.getTournament().getEventDate();
    }
}
