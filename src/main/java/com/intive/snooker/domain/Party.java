package com.intive.snooker.domain;

import com.intive.snooker.api.dto.PartyDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer firstPlayerPoints;
    private Integer secondPlayerPoints;

    public Party(PartyDto partyDto) {
        this.firstPlayerPoints = partyDto.getFirstPlayerPoints();
        this.secondPlayerPoints = partyDto.getSecondPlayerPoints();
    }
}
