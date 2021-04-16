package com.football.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Сущность матча")
public class MatchDto {
    @Schema(description = "Идентификатор")
    private final Long id;

    @Schema(description = "Название команды хозяев")
    private final String homeTeam;

    @Schema(description = "Название команды гостей")
    private final String guestTeam;

    @Schema(description = "Голы хозяев")
    private final Long homeGoals;

    @Schema(description = "Голы гостей")
    private final Long guestGoals;

    @Schema(description = "Название турнира")
    private final String tournamentName;

    public MatchDto(Long id, String homeTeam, String guestTeam, Long homeGoals, Long guestGoals, String tournamentName) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
        this.tournamentName = tournamentName;
    }
}
