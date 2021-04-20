package com.football.controllers;

import com.football.dto.TournamentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TournamentController", description = "Контроллер, отвечающий за работу с футбольными турнирами")
@RestController
@RequestMapping(value = "/tournaments")
public class TournamentsController {

    @Operation(summary = "Выдача списка турниров", description = "Выдаёт список всех футбольных турниров")
    @GetMapping(value = "/getall")
    public ResponseEntity getAllTournamensts() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Выдача информации о  турнире", description = "Выдаёт информацию о турнире по указанному id")
    @GetMapping(value = "/getone/{id}")
    public ResponseEntity getOneTournament(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Добавление футбольного турнира", description = "Добавляет новый футбольный турнир")
    @PostMapping(value = "/add")
    public ResponseEntity addTournament(@RequestBody TournamentDto tournamentDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Изменение информации о футбольном турнире", description = "Изменяет информацию о футбольном турнире по указанному id")
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity editTournament(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id, @RequestBody TournamentDto tournamentDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Удаление футбольного турнира", description = "Удаляет футбольный турнир по указанному id")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteTournament(@PathVariable(name = "id") @Parameter(description = "id турнира") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
