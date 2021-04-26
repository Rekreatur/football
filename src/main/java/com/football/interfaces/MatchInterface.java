package com.football.interfaces;

import com.football.dto.MatchDto;

import com.football.response.ApiResponse;
import java.util.List;

public interface MatchInterface {
    ApiResponse<List<MatchDto>> findAll();

    ApiResponse<List<MatchDto>> finaAllTournament(Long id);

    ApiResponse<List<MatchDto>> findAllTeam(Long id);

    ApiResponse<MatchDto> getOne(Long id);

    ApiResponse add(MatchDto matchDto);

    ApiResponse edit(Long id, MatchDto matchDto);

    ApiResponse delete(Long id);
}
