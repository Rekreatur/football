package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema(description = "Сущность матча")
public final class MatchDto {

  @Schema(description = "Идентификатор")
  private final Long id;

  @Schema(description = "Id команды хозяев")
  @NotNull
  private final Long homeTeamId;

  @Schema(description = "Id команды гостей")
  @NotNull
  private final Long guestTeamId;

  @Min(value = 0)
  @Schema(description = "Голы хозяев")
  private final Integer homeGoals;

  @Min(value = 0)
  @Schema(description = "Голы гостей")
  private final Integer guestGoals;

  @Schema(description = "Id турнира")
  @NotNull
  private final Long tournamentId;

  public MatchDto(Long id, Long homeTeam, Long guestTeam, Integer homeGoals, Integer guestGoals,
      Long tournamentName) {
    this.id = id;
    this.homeTeamId = homeTeam;
    this.guestTeamId = guestTeam;
    this.homeGoals = homeGoals;
    this.guestGoals = guestGoals;
    this.tournamentId = tournamentName;
  }
}
