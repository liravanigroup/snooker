package com.intive.snooker.api;

import com.intive.snooker.api.dto.MatchDto;
import com.intive.snooker.api.dto.PartyDto;
import com.intive.snooker.api.dto.RoundDto;
import com.intive.snooker.api.dto.TournamentDto;
import com.intive.snooker.api.request.CreateTournamentRequest;
import com.intive.snooker.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Service
@AllArgsConstructor
public class TournamentFactory {

    private PlayerRepository playerRepository;

    public Tournament createTournament(CreateTournamentRequest request) {
        TournamentDto tournament = request.getTournament();

        Map<Integer, String> levelMap = getLevelMap();
        int levelIndex = 0;

        Collection<RoundDto> rounds = tournament.getRoundsList();
        Collection<Round> roundCollection = new LinkedList<>();
        for (RoundDto round : rounds) {
            Collection<MatchDto> matches = round.getMatches();
            Collection<Match> matchCollection = new LinkedList<>();
            for (MatchDto match : matches) {
                Player firstPlayer = playerRepository.load(match.getFirstPlayerId());
                Player secondPlayer = playerRepository.load(match.getSecondPlayerId());
                Collection<Party> parties = new LinkedList<>();
                for (PartyDto party : match.getParties()) {
                    parties.add(new Party(party));
                }
                matchCollection.add(new Match(parties, firstPlayer, secondPlayer));
            }
            roundCollection.add(new Round(matchCollection, levelMap.get(levelIndex++)));
        }
        return new Tournament(tournament.getEventDate(), roundCollection);
    }


    private Map<Integer, String> getLevelMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(0, "Final");
        result.put(1, "1/2");
        result.put(2, "1/4");
        result.put(3, "1/8");
        result.put(4, "1/16");
        result.put(5, "1/32");
        return result;
    }

}
