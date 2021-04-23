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


    public ApiResponse<List<TournamentDto>> findAll() {
        return new ApiResponse<>("The list was issued successfully", Status.OK, tournamentConverter.entityToDto(tournamentRepository.findAll()));
    }


    public ApiResponse<TournamentDto> getOne(Long id) {
        return new ApiResponse<>("The tournament issued successfully", Status.OK, tournamentConverter.entityToDto(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()))));
    }


    public ApiResponse add(TournamentDto tournamentDto) {
        tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournamentConverter.dtoToEntity(tournamentDto)));
        return new ApiResponse("The tournament added successfully", Status.OK);
    }


    public ApiResponse edit(Long id, TournamentDto tournamentDto) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        tournamentConverter.dtoToEntityEdit(tournament, tournamentDto);
        tournamentConverter.entityToDto(tournamentRepository.saveAndFlush(tournament));
        return new ApiResponse("The tournament edited successfully", Status.OK);
    }


    public ApiResponse delete(Long id) {
        tournamentRepository.delete(tournamentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return new ApiResponse("Delete successfully", Status.OK);
    }
}
