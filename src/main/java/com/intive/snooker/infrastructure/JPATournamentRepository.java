package com.intive.snooker.infrastructure;

import com.intive.snooker.api.response.ListTournamentsResponse;
import com.intive.snooker.api.response.TournamentDtoResponse;
import com.intive.snooker.domain.Tournament;
import com.intive.snooker.domain.TournamentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Repository
public class JPATournamentRepository implements TournamentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ListTournamentsResponse getTournamentByYear(Year tournamentYear) {

        List<Tournament> tournaments = entityManager.createQuery("select t from Tournament t " +

                "WHERE year(t.date)=:year", Tournament.class)
                .setParameter("year", tournamentYear.getValue())
                .getResultList();
        List<TournamentDtoResponse> result = tournaments.stream().map(TournamentDtoResponse::new).collect(Collectors.toList());
        return new ListTournamentsResponse(result);
    }

    @Override
    public void save(Tournament tournament) {
        entityManager.persist(tournament);
    }

    @Override
    public Tournament load(LocalDate tournamentDate) {
        List<Tournament> tournaments =  entityManager.createQuery("FROM Tournament t WHERE t.date=:date", Tournament.class)
                .setParameter("date", tournamentDate)
                .getResultList();
        if(tournaments.isEmpty())
            return null;
        return tournaments.get(0);
    }
}
