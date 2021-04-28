package com.football.interfaces;

import com.football.dto.TournamentDto;

import com.football.response.ApiResponse;
import java.util.List;

public interface TournamentInterface {
    List<TournamentDto> findAll();

    TournamentDto getOne(Long id);

    TournamentDto add(TournamentDto tournamentDto);

    TournamentDto edit(Long id, TournamentDto tournamentDto);

    TournamentDto delete(Long id);
}
