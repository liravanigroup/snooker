package com.intive.snooker.api.dto;

import com.intive.snooker.api.InvalidRequestException;
import com.intive.snooker.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private String firstName;
    private String lastName;

    public void validate(){
        validateFirstName(firstName);
        validateLastName(lastName);
    }

    public PlayerDto(Player player){
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
    }

    private void validateFirstName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty())
            throw new InvalidRequestException("First name is required");
        if(lastName.length() < 3)
            throw new InvalidRequestException("First name is too short");
    }

    private void validateLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty())
            throw new InvalidRequestException("Last name is required");
        if(lastName.length() < 3)
            throw new InvalidRequestException("Last name is too short");
    }
}
