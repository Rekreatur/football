package com.football.converter;

import com.football.domain.Tournament;
import com.football.dto.TournamentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentConverter {
    public TournamentDto entityToDto(Tournament tournament) {
        return new TournamentDto(tournament.getId(), tournament.getTournamentName(), tournament.getStartYear());
    }

    public List<TournamentDto> entityToDto(List<Tournament> tournaments) {
        return tournaments.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Tournament dtoToEntity(TournamentDto tournamentDto) {
        Tournament tournament = new Tournament();
        tournament.setId(tournamentDto.getId());
        tournament.setTournamentName(tournamentDto.getTournamentName());
        tournament.setStartYear(tournamentDto.getStartYear());
        return tournament;
    }

    public List<Tournament> dtoToEntity(List<TournamentDto> tournamentDtos) {
        return tournamentDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    public Tournament dtoToEntityEdit(Tournament tournament, TournamentDto tournamentDto) {
        tournament.setTournamentName(tournamentDto.getTournamentName());
        tournament.setStartYear(tournamentDto.getStartYear());
        return tournament;
    }

}
