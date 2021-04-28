package com.football.services;

import com.football.converter.TournamentConverter;
import com.football.domain.Tournament;
import com.football.dto.TournamentDto;
import com.football.interfaces.TournamentInterface;
import com.football.repository.TournamentRepository;
import com.football.response.ApiResponse;
import com.football.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
        return tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournamentConverter.dtoToEntity(tournamentDto)));
    }


    public TournamentDto edit(Long id, TournamentDto tournamentDto) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        tournamentConverter.dtoToEntityEdit(tournament, tournamentDto);
        return tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournament));
    }


    public TournamentDto delete(Long id) {
        TournamentDto tournamentDto = tournamentConverter.entityToDto(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        tournamentRepository.delete(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return tournamentDto;
    }
}
