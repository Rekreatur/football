package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
@Schema(description = "Сущность турнира")
public final class TournamentDto {
    @Schema(description = "Идентификатор")
    private final Long id;

    @Schema(description = "Название турнира")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String tournamentName;

    @Schema(description = "Год проведения")
    @Min(value = 2021)
    private final Integer year;

    public TournamentDto(Long id, String tournamentName, Integer year) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.year = year;
    }
}
