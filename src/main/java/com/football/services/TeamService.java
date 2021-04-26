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

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeamService implements TeamInterface {
    @Autowired
    TeamConverter teamConverter;

    @Autowired
    TeamRepository teamRepository;

    public ApiResponse<List<TeamDto>> findAll() {
        return new ApiResponse<>("The list was issued successfully", Status.OK, teamConverter.entityToDto(teamRepository.findAll()));
    }

    public ApiResponse<TeamDto> getOne(Long id) {
        return new ApiResponse<>("The team issued successfully",Status.OK, teamConverter.entityToDto(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()))));
    }

    public ApiResponse add(TeamDto teamDto) {
        teamConverter.entityToDto(teamRepository.saveAndFlush(teamConverter.dtoToEntity(teamDto)));
        return new ApiResponse("The team added successfully", Status.OK);
    }

    public ApiResponse edit(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException((id.toString())));
        teamConverter.dtoToEntityEdit(team, teamDto);
        teamConverter.entityToDto(teamRepository.saveAndFlush(team));
        return new ApiResponse("The team edited successfully", Status.OK);
    }

    public ApiResponse delete(Long id) {
        teamRepository.delete(teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return new ApiResponse("Delete successfully", Status.OK);
    }

}
