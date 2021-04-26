package com.football.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel(description = "Сущность, содержащая информацию о матче")
@Getter
public final class MatchDto {
  @ApiModelProperty(notes = "id матча, которое генерируется базой данных")
  private final Long id;

  @ApiModelProperty(notes = "Команда хозяев")
  @NotNull
  private final Long homeTeam;

  @ApiModelProperty(notes = "Команда гостей")
  @NotNull
  private final Long guestTeam;

  @ApiModelProperty(notes = "Количество голов команды хозяев")
  @Min(value = 0)
  private final Integer homeGoals;

  @ApiModelProperty(notes = "Количество голов команды гостей")
  @Min(value = 0)
  private final Integer guestGoals;

  @ApiModelProperty(notes = "Турнир")
  @NotNull
  private final Long tournament;

  public MatchDto(Long id, Long homeTeam, Long guestTeam, Integer homeGoals, Integer guestGoals,
      Long tournamentName) {
    this.id = id;
    this.homeTeam = homeTeam;
    this.guestTeam = guestTeam;
    this.homeGoals = homeGoals;
    this.guestGoals = guestGoals;
    this.tournament = tournamentName;
  }
}
