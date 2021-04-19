package com.football.interfaces;

import com.football.dto.TeamDto;

import java.util.List;

public interface TeamInterface {
    List<TeamDto> findAll();

    TeamDto getOneTeam(Long id);

    TeamDto addTeam(TeamDto teamDto);

    TeamDto edit(Long id, TeamDto teamDto);

    void delete(Long id);
}
