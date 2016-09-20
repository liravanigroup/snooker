package com.intive.snooker.domain;

import com.intive.snooker.api.PlayerDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    public Player(PlayerDto player) {
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
    }
}
