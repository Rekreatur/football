package com.football.interfaces;

import com.football.dto.MatchDto;

import java.util.List;

public interface MatchInterface {
    List<MatchDto> findAll();

    MatchDto getOneTeam(Long id);

    MatchDto addTeam(MatchDto matchDto);

    MatchDto edit(Long id, MatchDto matchDto);

    void delete(Long id);
}
