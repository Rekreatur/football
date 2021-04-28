package com.football.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.Size;

@ApiModel(description = "Сущность, содержащая информацию о турнире")
@Getter
public final class TournamentDto {
    @ApiModelProperty(notes = "id турнира, которое генерируется базой данных")
    private final Long id;

    @ApiModelProperty(notes = "Название турнира")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String tournamentName;

    @ApiModelProperty(notes = "Год начала проведения турнира")
    @Min(value = 1900)
    private final Integer startYear;

    public TournamentDto(Long id, String tournamentName, Integer startYear) {
        this.id = id;
        this.tournamentName = tournamentName;
        this.startYear = startYear;
    }
}
