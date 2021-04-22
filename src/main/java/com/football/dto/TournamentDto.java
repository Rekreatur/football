package com.football.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public final class TournamentDto {
    private final Long id;

    @NotBlank
    @Size(min = 2, max = 80)
    private final String tournamentName;

    @Min(value = 2021)
    private final Integer year;

    public TournamentDto(Long id, String tournamentName, Integer year) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.year = year;
    }
}
