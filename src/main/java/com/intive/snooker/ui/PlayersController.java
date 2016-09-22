package com.intive.snooker.ui;

import com.intive.snooker.api.request.CreatePlayerRequest;
import com.intive.snooker.api.response.ListAllPlayersResponse;
import com.intive.snooker.api.PlayerManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayersController {

    private PlayerManager playerManager;


    @PutMapping
    public void createPlayer(@RequestBody CreatePlayerRequest request){
        playerManager.createPlayer(request);
    }

    @GetMapping
    public ListAllPlayersResponse getAllPlayers(){
        return playerManager.getAllPlayers();
    }

    @DeleteMapping("/{playerId}")
    public void deleteUser(@PathVariable Long playerId){
        playerManager.deletePlayer(playerId);
    }

}
