package com.football.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
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
