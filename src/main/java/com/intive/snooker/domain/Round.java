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
public class Round{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Match> matches;


    public Round(Collection<Match> matches, String level) {
        this.matches = matches;
        this.level = level;
    }
}
