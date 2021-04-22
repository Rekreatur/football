package com.football.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public final class TeamDto {
    private final Long id;

    @NotBlank
    @Size(min = 2, max = 80)
    private final String teamName;

    @NotBlank
    @Size(min = 2, max = 80)
    private final String cityName;

    public TeamDto(Long id, String teamName, String cityName) {
        this.id = id;
        this.teamName = teamName;
        this.cityName = cityName;
    }
}
