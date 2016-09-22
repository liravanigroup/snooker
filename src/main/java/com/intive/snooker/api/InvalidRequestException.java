package com.intive.snooker.api;

/**
 * Created by Sergej Povzaniuk on 20.09.2016.
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
