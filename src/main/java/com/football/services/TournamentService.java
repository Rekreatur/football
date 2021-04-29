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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService implements TournamentInterface {
    final
    TournamentConverter tournamentConverter;

    final
    TournamentRepository tournamentRepository;

    public TournamentService(TournamentConverter tournamentConverter, TournamentRepository tournamentRepository) {
        this.tournamentConverter = tournamentConverter;
        this.tournamentRepository = tournamentRepository;
    }


    public List<TournamentDto> findAll() {
        List<TournamentDto> tournamentDtos = new ArrayList<>();
        tournamentRepository.findAll().forEach(x -> tournamentDtos.add(tournamentConverter.entityToDto(x)));
        return tournamentDtos;
    }


    public Optional<TournamentDto> getOne(Long id) {
        if(!tournamentRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(tournamentConverter.entityToDto(tournamentRepository.findById(id).get()));
    }


    public TournamentDto add(TournamentDto tournamentDto) {
        return tournamentConverter.entityToDto(tournamentRepository.save(tournamentConverter.dtoToEntity(tournamentDto)));
    }


    public Optional<TournamentDto> edit(Long id, TournamentDto tournamentDto) {
        if(!tournamentRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        tournamentConverter.dtoToEntityEdit(tournamentRepository.findById(id).get(), tournamentDto);
        return Optional.of(tournamentConverter.entityToDto(tournamentRepository.save(tournamentRepository.findById(id).get())));
    }


    public Optional<TournamentDto> delete(Long id) {
        if(!tournamentRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        TournamentDto tournamentDto = tournamentConverter.entityToDto(tournamentRepository.findById(id).get());
        tournamentRepository.delete(tournamentRepository.findById(id).get());
        return Optional.of(tournamentDto);
    }
}
