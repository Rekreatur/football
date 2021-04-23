package com.football.interfaces;

import com.football.dto.TeamDto;
import com.football.response.ApiResponse;

import java.util.List;

public interface TeamInterface {
    ApiResponse<List<TeamDto>> findAll();

    ApiResponse<TeamDto> getOne(Long id);

    ApiResponse<TeamDto> add(TeamDto teamDto);

    ApiResponse<TeamDto> edit(Long id, TeamDto teamDto);

    ApiResponse delete (Long id);
}
