package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Сущность команды")
public final class TeamDto {
    @Schema(description = "Идентификатор")
    private final Long id;

    @Schema(description = "Название команды")
    private final String teamName;

    @Schema(description = "Название города")
    private final String cityName;

    public TeamDto(Long id, String teamName, String cityName) {
        this.id = id;
        this.teamName = teamName;
        this.cityName = cityName;
    }
}
