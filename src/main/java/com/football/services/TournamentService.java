package com.football.services;

import com.football.converter.TournamentConverter;
import com.football.domain.Tournament;
import com.football.dto.TournamentDto;
import com.football.interfaces.TournamentInterface;
import com.football.repository.TournamentRepository;
import com.football.response.ApiResponse;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TournamentService implements TournamentInterface {
  @Autowired
  TournamentConverter tournamentConverter;

  @Autowired
  TournamentRepository tournamentRepository;



  public List<TournamentDto> findAll() {
    return tournamentConverter.entityToDto(tournamentRepository.findAll());
  }


  public TournamentDto getOne(Long id) {
    return tournamentConverter.entityToDto(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
  }


  public TournamentDto add(TournamentDto tournamentDto) {
    Tournament tournament = tournamentConverter.dtoToEntity(tournamentDto);
    return tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournament));
  }


  public TournamentDto edit(Long id, TournamentDto tournamentDto) {
    Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    tournamentConverter.dtoToEntityEdit(tournament,tournamentDto);
    return tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournament));
  }


  public ApiResponse delete(Long id) {
    tournamentRepository.delete(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    return new ApiResponse("Delete successfully", HttpStatus.OK);
  }
}
