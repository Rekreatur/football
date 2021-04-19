package com.football.interfaces;

import com.football.dto.TeamDto;
import com.football.dto.TournamentDto;

import java.util.List;

public interface TournamentInterface {
    List<TournamentDto> findAll();

    TournamentDto getOneTeam(Long id);

    TournamentDto addTeam(TournamentDto tournamentDto);

    TournamentDto edit(Long id, TournamentDto tournamentDto);

    void delete(Long id);
}
