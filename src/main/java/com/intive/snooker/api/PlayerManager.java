package com.intive.snooker.api;

import com.intive.snooker.api.dto.PlayerDto;
import com.intive.snooker.api.request.CreatePlayerRequest;
import com.intive.snooker.api.response.ListAllPlayersResponse;
import com.intive.snooker.domain.Player;
import com.intive.snooker.domain.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Service
@AllArgsConstructor
public class PlayerManager {

    private PlayerRepository playerRepository;
    private PlayerFactory playerFactory;

    @Transactional
    public void createPlayer(CreatePlayerRequest request) {
        request.validate();
        Player newPlayer = playerFactory.createPlayer(request);
        validateDuplicate(newPlayer);
        playerRepository.save(newPlayer);
    }

    private void validateDuplicate(Player newPlayer) {
        Player player = playerRepository.load(newPlayer.getFirstName(), newPlayer.getLastName());
        if (player != null)
            throw new InvalidRequestException(
                    String.format(
                            "Player with first name %s and last name %s already exists",
                            player.getFirstName(),
                            player.getLastName()
                    )
            );
    }

    @Transactional
    public void deletePlayer(Long playerId) {
        validatePlayerId(playerId);
        playerRepository.delete(playerId);
    }

    private void validatePlayerId(Long playerId) {
        if (playerId == null)
            throw new InvalidRequestException("Player id is required");
        if (playerId < 0)
            throw new InvalidRequestException("Entered player id " + playerId + " out of bounds");
    }

    public ListAllPlayersResponse getAllPlayers() {
        List<PlayerDto> players = playerRepository.getAllPlayers().stream().map(PlayerDto::new).collect(Collectors.toList());
        return new ListAllPlayersResponse(players);
    }
}
