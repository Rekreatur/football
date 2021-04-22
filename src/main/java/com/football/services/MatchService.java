package com.football.services;

import com.football.converter.MatchConverter;
import com.football.domain.Match;
import com.football.dto.MatchDto;
import com.football.interfaces.MatchInterface;
import com.football.repository.MatchRepository;
import com.football.response.ApiResponse;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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


  public ApiResponse add(MatchDto matchDto) {
    if (matchDto.getHomeTeam().equals(matchDto.getGuestTeam())) {
      return new ApiResponse("Команда не может играть сама с собой", HttpStatus.BAD_REQUEST);
    }
    Match match = matchConverter.dtoToEntity(matchDto);
    matchConverter.entityToDto(matchRepository.saveAndFlush(match));
    return new ApiResponse("Match added successfully", HttpStatus.OK);
  }


  public MatchDto edit(Long id, MatchDto matchDto) {
    Match match = matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    matchConverter.dtoToEntityEdit(match, matchDto);
    return matchConverter.entityToDto(matchRepository.saveAndFlush(match));
  }


  public ApiResponse delete(Long id) {
    matchRepository.delete(matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    return new ApiResponse("Delete successfully", HttpStatus.OK);
  }
}
