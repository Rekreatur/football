package com.football.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse extends ResponseEntity {

    public ApiResponse(String message) {
        super(message,HttpStatus.OK);
    }
}
