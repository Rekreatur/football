package com.football.services;

import com.football.converter.MatchConverter;
import com.football.domain.Match;
import com.football.dto.MatchDto;
import com.football.exception.MatchException;
import com.football.interfaces.MatchInterface;
import com.football.repository.MatchRepository;
import com.football.repository.TeamRepository;
import com.football.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService implements MatchInterface {

    final
    MatchConverter matchConverter;

    final
    MatchRepository matchRepository;

    final
    TeamRepository teamRepository;

    final
    TournamentRepository tournamentRepository;

    public MatchService(MatchConverter matchConverter, MatchRepository matchRepository, TeamRepository teamRepository, TournamentRepository tournamentRepository) {
        this.matchConverter = matchConverter;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public List<MatchDto> findAll() {
        List<MatchDto> matchDtos = new ArrayList<>();
        matchRepository.findAll().forEach(x -> matchDtos.add(matchConverter.entityToDto(x)));
        return matchDtos;
    }


    public Optional<List<MatchDto>> findAllTournament(Long id) {
        List<MatchDto> matchDtos = new ArrayList<>();
        if (!tournamentRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        matchRepository.findAll().forEach(x -> matchDtos.add(matchConverter.entityToDto(x)));
        return Optional.of(matchDtos.stream()
                .filter(x -> x.getId() != null)
                .filter(x -> x.getTournament().getId().equals(id))
                .collect(
                        Collectors.toList()));
    }


    public Optional<List<MatchDto>> findAllTeam(Long id) {
        List<MatchDto> matchDtos = new ArrayList<>();
        if (!teamRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        matchRepository.findAll().forEach(x -> matchDtos.add(matchConverter.entityToDto(x)));
        return Optional.of(matchDtos.stream()
                .filter(x -> x.getHomeTeam().getId() != null && x.getGuestTeam().getId() != null)
                .filter(x -> x.getHomeTeam().getId().equals(id) || x.getGuestTeam().getId().equals(id))
                .collect(
                        Collectors.toList()));
    }


    public Optional<MatchDto> getOne(Long id) {
        if (!matchRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(matchConverter.entityToDto(
                matchRepository.findById(id).get()));
    }


    public MatchDto add(MatchDto matchDto) throws MatchException {
        if (matchDto.getHomeTeam().getId().equals(matchDto.getGuestTeam().getId())) {
            throw new MatchException("Команда не может играть сама с собой");
        }
        Match match = matchConverter.dtoToEntity(matchDto);
        return matchConverter.entityToDto(matchRepository.save(match));
    }


    public Optional<MatchDto> edit(Long id, MatchDto matchDto) {
        if (!matchRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        matchConverter.dtoToEntityEdit(matchRepository.findById(id).get(), matchDto);
        return Optional.of(matchConverter.entityToDto(matchRepository.save(matchRepository.findById(id).get())));
    }


    public Optional<MatchDto> delete(Long id) {
        if (!matchRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        MatchDto matchDto = matchConverter.entityToDto(matchRepository.findById(id).get());
        matchRepository.delete(matchRepository.findById(id).get());
        return Optional.of(matchDto);
    }
}
