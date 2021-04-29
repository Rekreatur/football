package com.football.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Сущность, содержащая информацию о городе")
@Getter
public final class CityDto {
    @ApiModelProperty(notes = "id матча, которое генерируется базой данных")
    private final Long id;

    @ApiModelProperty(notes = "Название города")
    @NotBlank
    @Size(min = 2, max = 80)
    private final String name;

    public CityDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
