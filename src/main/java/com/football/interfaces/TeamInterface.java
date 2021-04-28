package com.football.interfaces;

import com.football.dto.TeamDto;

import java.util.List;

public interface TeamInterface {
    List<TeamDto> findAll();

    TeamDto getOne(Long id);

    TeamDto add(TeamDto teamDto);

    TeamDto edit(Long id, TeamDto teamDto);

    TeamDto delete(Long id);
}
