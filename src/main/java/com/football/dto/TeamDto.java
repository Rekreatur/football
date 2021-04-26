package com.football.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Сущность, содержащая информацию о команде")
@Getter
public final class TeamDto {
    @ApiModelProperty(notes = "id команды, которое генерируется базой данных")
    private final Long id;

    @ApiModelProperty(notes = "Название команды")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String teamName;

    @ApiModelProperty(notes = "Название города команды")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String cityName;

    public TeamDto(Long id, String teamName, String cityName) {
        this.id = id;
        this.teamName = teamName;
        this.cityName = cityName;
    }
}
