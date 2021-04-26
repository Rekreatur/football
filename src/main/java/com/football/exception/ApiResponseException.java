package com.football.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiResponseException {
    private String message;
    private String debugMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;



    public ApiResponseException() {
    }

    public ApiResponseException(String message, String debugMessage) {
        this.message = message;
        this.debugMessage = debugMessage;
    }

}
