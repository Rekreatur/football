package com.football.services;


import com.football.converter.TeamConverter;
import com.football.domain.Team;
import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import com.football.repository.TeamRepository;
import com.football.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamService implements TeamInterface {
    @Autowired
    TeamConverter teamConverter;

    @Autowired
    TeamRepository teamRepository;

    public List<TeamDto> findAll() {
        return teamConverter.entityToDto(teamRepository.findAll());
    }

    public TeamDto getOne(Long id) {
        return teamConverter.entityToDto(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    }

    public TeamDto add(TeamDto teamDto) {
        Team team = teamConverter.dtoToEntity(teamDto);
        return teamConverter.entityToDto(teamRepository.saveAndFlush(team));
    }

    public TeamDto edit(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException((id.toString())));
        teamConverter.dtoToEntityEdit(team, teamDto);
        return teamConverter.entityToDto(teamRepository.saveAndFlush(team));
    }

    public ApiResponse delete(Long id) {
        teamRepository.delete(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return new ApiResponse("Delete successfully", HttpStatus.OK);
    }
}
