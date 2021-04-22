package com.football.converter;

import com.football.domain.Match;
import com.football.dto.MatchDto;
import com.football.repository.TeamRepository;
import com.football.repository.TournamentRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchConverter {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  TournamentRepository tournamentRepository;

  public MatchDto entityToDto(Match match) {
    return new MatchDto(match.getId(), match.getHomeTeam().getId(),
        match.getGuestTeam().getId(), match.getHomeGoals(), match.getGuestGoals(),
        match.getTournament().getId());
  }

  public List<MatchDto> entityToDto(List<Match> matches) {
    return matches.stream().map(this::entityToDto).collect(Collectors.toList());
  }

  public Match dtoToEntity(MatchDto matchDto) {
    Match match = new Match();
    match.setHomeTeam(teamRepository.findById(matchDto.getHomeTeam())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getHomeTeam().toString())));
    match.setGuestTeam(teamRepository.findById(matchDto.getGuestTeam())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getGuestTeam().toString())));
    match.setHomeGoals(matchDto.getHomeGoals());
    match.setGuestGoals(matchDto.getGuestGoals());
    match.setTournament(tournamentRepository.findById(matchDto.getTournament())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getTournament().toString())));
    return match;
  }

  public List<Match> dtoToEntity(List<MatchDto> matchDtos) {
    return matchDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
  }

  public Match dtoToEntityEdit(Match match, MatchDto matchDto) {
    match.setHomeTeam(teamRepository.findById(matchDto.getHomeTeam())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getHomeTeam().toString())));
    match.setGuestTeam(teamRepository.findById(matchDto.getGuestTeam())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getGuestTeam().toString())));
    match.setHomeGoals(matchDto.getHomeGoals());
    match.setGuestGoals(matchDto.getGuestGoals());
    match.setTournament(tournamentRepository.findById(matchDto.getTournament())
        .orElseThrow(() -> new EntityNotFoundException(matchDto.getTournament().toString())));
    return match;
  }
}
