package com.football.converter;

import com.football.domain.Match;
import com.football.dto.MatchDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchConverter {

    final
    TeamConverter teamConverter;

    final
    TournamentConverter tournamentConverter;

    public MatchConverter(TeamConverter teamConverter, TournamentConverter tournamentConverter) {
        this.teamConverter = teamConverter;
        this.tournamentConverter = tournamentConverter;
    }

    public MatchDto entityToDto(Match match) {
        return new MatchDto(match.getId(), teamConverter.entityToDto(match.getHomeTeam()),
                teamConverter.entityToDto(match.getGuestTeam()), match.getHomeGoals(), match.getGuestGoals(),
                tournamentConverter.entityToDto(match.getTournament()));
    }

    public List<MatchDto> entityToDto(List<Match> matches) {
        return matches.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Match dtoToEntity(MatchDto matchDto) {
        Match match = new Match();
        match.setHomeTeam(teamConverter.dtoToEntity(matchDto.getHomeTeam()));
        match.setGuestTeam(teamConverter.dtoToEntity(matchDto.getGuestTeam()));
        match.setHomeGoals(matchDto.getHomeGoals());
        match.setGuestGoals(matchDto.getGuestGoals());
        match.setTournament(tournamentConverter.dtoToEntity(matchDto.getTournament()));
        return match;
    }

    public List<Match> dtoToEntity(List<MatchDto> matchDtos) {
        return matchDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    public Match dtoToEntityEdit(Match match, MatchDto matchDto) {
        match.setHomeTeam(teamConverter.dtoToEntity(matchDto.getHomeTeam()));
        match.setGuestTeam(teamConverter.dtoToEntity(matchDto.getGuestTeam()));
        match.setHomeGoals(matchDto.getHomeGoals());
        match.setGuestGoals(matchDto.getGuestGoals());
        match.setTournament(tournamentConverter.dtoToEntity(matchDto.getTournament()));
        return match;
    }
}
