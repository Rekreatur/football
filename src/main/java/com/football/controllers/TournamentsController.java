package com.football.controllers;

import com.football.dto.TournamentDto;
import com.football.interfaces.TournamentInterface;
import com.football.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TournamentController", description = "Контроллер, отвечающий за работу с футбольными турнирами")
@RestController
@RequestMapping(value = "/tournaments")
public class TournamentsController {
    @Autowired
    TournamentInterface tournamentService;

    @Operation(summary = "Выдача списка турниров", description = "Выдаёт список всех футбольных турниров")
    @GetMapping(value = "/getall")
    public List<TournamentDto> getAll() {
        return tournamentService.findAll();
    }

    @Operation(summary = "Выдача информации о  турнире", description = "Выдаёт информацию о турнире по указанному id")
    @GetMapping(value = "/getone/{id}")
    public TournamentDto getOne(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id) {
        return tournamentService.getOne(id);
    }

    @Operation(summary = "Добавление футбольного турнира", description = "Добавляет новый футбольный турнир")
    @PostMapping(value = "/add")
    public TournamentDto add(@RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.add(tournamentDto);
    }

    @Operation(summary = "Изменение информации о футбольном турнире", description = "Изменяет информацию о футбольном турнире по указанному id")
    @PutMapping(value = "/edit/{id}")
    public TournamentDto editTournament(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id, @RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.edit(id, tournamentDto);
    }

    @Operation(summary = "Удаление футбольного турнира", description = "Удаляет футбольный турнир по указанному id")
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteTournament(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id) {
        return tournamentService.delete(id);
    }
}
