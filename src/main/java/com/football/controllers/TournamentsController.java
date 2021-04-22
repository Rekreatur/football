package com.football.controllers;

import com.football.dto.TournamentDto;
import com.football.interfaces.TournamentInterface;
import com.football.response.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tournaments")
public class TournamentsController {
    @Autowired
    TournamentInterface tournamentService;

    @GetMapping(value = "/getall")
    public List<TournamentDto> getAll() {
        return tournamentService.findAll();
    }

    @GetMapping(value = "/getone/{id}")
    public TournamentDto getOne(@PathVariable(name = "id") Long id) {
        return tournamentService.getOne(id);
    }

    @PostMapping(value = "/add")
    public TournamentDto add(@RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.add(tournamentDto);
    }

    @PutMapping(value = "/edit/{id}")
    public TournamentDto editTournament(@PathVariable(name = "id") Long id, @RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.edit(id, tournamentDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteTournament(@PathVariable(name = "id") Long id) {
        return tournamentService.delete(id);
    }
}
