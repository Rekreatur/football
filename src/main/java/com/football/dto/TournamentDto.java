package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
@Schema(description = "Сущность турнира")
public class TournamentDto {
    @Schema(description = "Идентификатор")
    private final Long id;

    @Schema(description = "Название турнира")
    private final String tournamentName;

    @Schema(description = "Год проведения")
    @Size(min = 4, max = 4)
    private final Integer year;

    public TournamentDto(Long id, String tournamentName, Integer year) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.year = year;
    }
}
