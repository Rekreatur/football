package com.football.interfaces;

import com.football.dto.TournamentDto;

import com.football.response.ApiResponse;
import java.util.List;

public interface TournamentInterface {
    ApiResponse<List<TournamentDto>> findAll();

    ApiResponse<TournamentDto> getOne(Long id);

    ApiResponse add(TournamentDto tournamentDto);

    ApiResponse edit(Long id, TournamentDto tournamentDto);

    ApiResponse delete(Long id);
}
