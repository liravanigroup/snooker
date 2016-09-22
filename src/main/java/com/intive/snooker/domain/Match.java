package com.intive.snooker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Player firstPlayer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Player secondPlayer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Party> parties;


    public Match(Collection<Party> parties, Player firstPlayer, Player secondPlayer) {
        this.parties = parties;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }
}
