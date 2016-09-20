package com.intive.snooker.ui;

import com.intive.snooker.api.CreatePlayerRequest;
import com.intive.snooker.api.PlayerManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
