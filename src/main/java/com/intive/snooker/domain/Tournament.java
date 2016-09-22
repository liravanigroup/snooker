package com.intive.snooker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Collection<Round> rounds;

    public Tournament(LocalDate date, Collection<Round> rounds) {
        this.date = date;
        this.rounds = rounds;
    }
}
