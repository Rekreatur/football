package com.football.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public final class MatchDto {

  private final Long id;

  @NotNull
  private final Long homeTeam;

  @NotNull
  private final Long guestTeam;

  @Min(value = 0)
  private final Integer homeGoals;

  @Min(value = 0)
  private final Integer guestGoals;

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
