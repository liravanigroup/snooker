package com.intive.snooker.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Sergej Povzaniuk on 21.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PartyDto {
    private Integer firstPlayerPoints;
    private Integer secondPlayerPoints;
}
