package com.football.services;


import com.football.converter.TeamConverter;
import com.football.domain.Team;
import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import com.football.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<TeamDto> teamDtos = new ArrayList<>();
        teamRepository.findAll().forEach(x -> teamDtos.add(teamConverter.entityToDto(x)));
        return teamDtos;
    }

    public Optional<TeamDto> getOne(Long id) {
        if(!teamRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(teamConverter.entityToDto(teamRepository.findById(id).get()));
    }

    public TeamDto add(TeamDto teamDto) {
        return teamConverter.entityToDto(teamRepository.save(teamConverter.dtoToEntity(teamDto)));
    }

    public Optional<TeamDto> edit(Long id, TeamDto teamDto) {
        if(!teamRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        teamConverter.dtoToEntityEdit(teamRepository.findById(id).get(), teamDto);
        return Optional.of(teamConverter.entityToDto(teamRepository.save(teamRepository.findById(id).get())));
    }

    public Optional<TeamDto> delete(Long id) {
        if(!teamRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        TeamDto teamDto = teamConverter.entityToDto(teamRepository.findById(id).get());
        teamRepository.delete(teamRepository.findById(id).get());
        return Optional.of(teamDto);
    }

}
