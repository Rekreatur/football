package com.football.interfaces;

import com.football.dto.TournamentDto;

import com.football.response.ApiResponse;
import java.util.List;
import java.util.Optional;

public interface TournamentInterface {
    List<TournamentDto> findAll();

    Optional<TournamentDto> getOne(Long id);

    TournamentDto add(TournamentDto tournamentDto);

    Optional<TournamentDto> edit(Long id, TournamentDto tournamentDto);

    Optional<TournamentDto> delete(Long id);
}
