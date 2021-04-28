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

import com.football.response.Status;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MatchService implements MatchInterface {

  @Autowired
  MatchConverter matchConverter;

  @Autowired
  MatchRepository matchRepository;

  public ApiResponse<List<MatchDto>> findAll() {
    return new ApiResponse<>("List of all matches successfully issued", Status.OK,matchConverter.entityToDto(matchRepository.findAll()));
  }


  public ApiResponse<List<MatchDto>> finaAllTournament(Long id) {
    return new ApiResponse<>("List of all tournament matches successfully issued", Status.OK,matchConverter.entityToDto(
        matchRepository.findAll().stream().filter(x -> x.getTournament().getId().equals(id))
            .collect(
                Collectors.toList())));
  }


  public ApiResponse<List<MatchDto>> findAllTeam(Long id) {
    return new ApiResponse<>("List of all team matches successfully issued", Status.OK,matchConverter.entityToDto(matchRepository.findAll().stream()
        .filter(x -> x.getHomeTeam().getId().equals(id) || x.getGuestTeam().getId().equals(id))
        .collect(
            Collectors.toList())));
  }


  public ApiResponse<MatchDto> getOne(Long id) {
    return new ApiResponse("Match successfully issued", Status.OK, matchConverter.entityToDto(
            matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()))));
  }


  public ApiResponse add(MatchDto matchDto) {
    if (matchDto.getHomeTeam().getId().equals(matchDto.getGuestTeam().getId())) {
      return new ApiResponse("Команда не может играть сама с собой", Status.ERROR);
    }
    Match match = matchConverter.dtoToEntity(matchDto);
    matchConverter.entityToDto(matchRepository.saveAndFlush(match));
    return new ApiResponse("Match added successfully", Status.OK);
  }


  public ApiResponse edit(Long id, MatchDto matchDto) {
    Match match = matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    matchConverter.dtoToEntityEdit(match, matchDto);
    matchConverter.entityToDto(matchRepository.saveAndFlush(match));
    return new ApiResponse("Match edited successfully", Status.OK);
  }


  public ApiResponse<MatchDto> delete(Long id) {
    matchRepository.delete(matchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    return new ApiResponse<>("Delete successfully", Status.OK);
  }
}
