package com.football.interfaces;

import com.football.dto.TeamDto;

import java.util.List;
import java.util.Optional;

public interface TeamInterface {
    List<TeamDto> findAll();

    Optional<TeamDto> getOne(Long id);

    TeamDto add(TeamDto teamDto);

    Optional<TeamDto> edit(Long id, TeamDto teamDto);

    Optional<TeamDto> delete(Long id);
}
