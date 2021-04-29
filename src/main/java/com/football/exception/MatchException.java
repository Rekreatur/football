package com.football.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchException extends Exception {
    private String message;

    public MatchException(String message) {
        this.message = message;
    }
}
