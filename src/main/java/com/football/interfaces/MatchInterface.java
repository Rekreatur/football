package com.football.interfaces;

import com.football.dto.MatchDto;
import com.football.exception.MatchException;

import java.util.List;
import java.util.Optional;

public interface MatchInterface {
    List<MatchDto> findAll();

    Optional<List<MatchDto>> finaAllTournament(Long id);

    Optional<List<MatchDto>> findAllTeam(Long id);

    Optional<MatchDto> getOne(Long id);

    MatchDto add(MatchDto matchDto) throws MatchException;

    Optional<MatchDto> edit(Long id, MatchDto matchDto);

    Optional<MatchDto> delete(Long id);
}
