package com.football.converter;

import com.football.domain.Team;
import com.football.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamConverter {
    public TeamDto entityToDto(Team team) {
        return new TeamDto(team.getId(), team.getTeamName(), team.getCityName());
    }

    public List<TeamDto> entityToDto(List<Team> teams) {
        return teams.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Team dtoToEntity(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setTeamName(teamDto.getTeamName());
        team.setCityName(teamDto.getCityName());
        return team;
    }

    public List<Team> dtoToEntity(List<TeamDto> teamDtos) {
        return teamDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    public Team dtoToEntityEdit(Team team, TeamDto teamDto) {
        team.setTeamName(teamDto.getTeamName());
        team.setCityName(teamDto.getCityName());
        return team;
    }


}
