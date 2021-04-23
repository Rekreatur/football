package com.football.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String s;
    private Status status;
    private T t;

    public ApiResponse(String s, Status status) {
        this.s = s;
        this.status = status;
    }

    public ApiResponse(String s, Status status, T t) {
        this.s = s;
        this.status = status;
        this.t = t;
    }
}
