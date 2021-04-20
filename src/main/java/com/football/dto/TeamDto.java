package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Schema(description = "Сущность команды")
public final class TeamDto {
    @Schema(description = "Идентификатор")
    private final Long id;

    @Schema(description = "Название команды")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String teamName;

    @Schema(description = "Название города")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String cityName;

    public TeamDto(Long id, String teamName, String cityName) {
        this.id = id;
        this.teamName = teamName;
        this.cityName = cityName;
    }
}
