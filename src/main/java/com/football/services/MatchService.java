package com.football.services;

import com.football.converter.MatchConverter;
import com.football.domain.Match;
import com.football.dto.MatchDto;
import com.football.exception.MatchException;
import com.football.interfaces.MatchInterface;
import com.football.repository.MatchRepository;
import com.football.response.ApiResponse;
import com.football.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService implements MatchInterface {

    @Autowired
    MatchConverter matchConverter;

    @Autowired
    MatchRepository matchRepository;

    public List<MatchDto> findAll() {
        return matchConverter.entityToDto(matchRepository.findAll());
    }


    public List<MatchDto> finaAllTournament(Long id) {
        return matchConverter.entityToDto(
                matchRepository.findAll().stream().filter(x -> x.getTournament().getId().equals(id))
                        .collect(
                                Collectors.toList()));
    }


    public List<MatchDto> findAllTeam(Long id) {
        return matchConverter.entityToDto(matchRepository.findAll().stream()
                .filter(x -> x.getHomeTeam().getId().equals(id) || x.getGuestTeam().getId().equals(id))
                .collect(
                        Collectors.toList()));
    }


    public MatchDto getOne(Long id) {
        return matchConverter.entityToDto(
                matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    }


    public MatchDto add(MatchDto matchDto) throws MatchException {
        if (matchDto.getHomeTeam().getId().equals(matchDto.getGuestTeam().getId())) {
            throw new MatchException("Команда не может играть сама с собой");
        }
        Match match = matchConverter.dtoToEntity(matchDto);
        return matchConverter.entityToDto(matchRepository.saveAndFlush(match));
    }


    public MatchDto edit(Long id, MatchDto matchDto) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        matchConverter.dtoToEntityEdit(match, matchDto);
        return matchConverter.entityToDto(matchRepository.saveAndFlush(match));
    }


    public MatchDto delete(Long id) {
        MatchDto matchDto = matchConverter.entityToDto(matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        matchRepository.delete(matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return matchDto;
    }
}
