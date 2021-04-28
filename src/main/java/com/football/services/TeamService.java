package com.football.services;


import com.football.converter.TeamConverter;
import com.football.domain.Team;
import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import com.football.repository.TeamRepository;
import com.football.response.ApiResponse;
import com.football.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamService implements TeamInterface {
    final
    TeamConverter teamConverter;

    final
    TeamRepository teamRepository;

    public TeamService(TeamConverter teamConverter, TeamRepository teamRepository) {
        this.teamConverter = teamConverter;
        this.teamRepository = teamRepository;
    }

    public List<TeamDto> findAll() {
        return teamConverter.entityToDto(teamRepository.findAll());
    }

    public TeamDto getOne(Long id) {
        return teamConverter.entityToDto(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    }

    public TeamDto add(TeamDto teamDto) {
        return teamConverter.entityToDto(teamRepository.saveAndFlush(teamConverter.dtoToEntity(teamDto)));
    }

    public TeamDto edit(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException((id.toString())));
        teamConverter.dtoToEntityEdit(team, teamDto);
        return teamConverter.entityToDto(teamRepository.saveAndFlush(team));
    }

    public TeamDto delete(Long id) {
        TeamDto teamDto = teamConverter.entityToDto(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        teamRepository.delete(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return teamDto;
    }

}
