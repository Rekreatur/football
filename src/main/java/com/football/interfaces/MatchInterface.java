package com.football.interfaces;

import com.football.dto.MatchDto;

import com.football.exception.MatchException;
import com.football.response.ApiResponse;
import java.util.List;

public interface MatchInterface {
    List<MatchDto> findAll();

    List<MatchDto> finaAllTournament(Long id);

    List<MatchDto> findAllTeam(Long id);

    MatchDto getOne(Long id);

    MatchDto add(MatchDto matchDto) throws MatchException;

    MatchDto edit(Long id, MatchDto matchDto);

    MatchDto delete(Long id);
}
