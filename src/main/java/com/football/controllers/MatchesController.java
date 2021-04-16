package com.football.controllers;

import com.football.dto.MatchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MatchController", description = "Контроллер, отвечающий за работу с футбольными матчами")
@RestController
@RequestMapping(value = "/football")
public class MatchesController {
    @Operation(summary = "Выдача списка матчей", description = "Выдаёт список всех футбольных матчей")
    @GetMapping(value = "/matches")
    public ResponseEntity getAllMatches() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Выдача списка матчей турнира", description = "Выдаёт список всех футбольных матчей по указанному турниру")
    @GetMapping(value = "/matches/tournaments/{tournament}")
    public ResponseEntity getAllMatchesTournament(@PathVariable(name = "tournament") @Parameter(description = "Название турнира") String tournamentName) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Выдача списка матчей команды", description = "Выдаёт список всех футбольных матчей по указанной команде")
    @GetMapping(value = "/matches/team/{team}")
    public ResponseEntity getAllMatchesTeam(@PathVariable(name = "team") @Parameter(description = "Название команды") String teamName) {
        System.out.println(teamName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Выдача информации о матче", description = "Выдаёт информацию о матче по указанному id")
    @GetMapping(value = "/matches/{id}")
    public ResponseEntity getOneMatch(@PathVariable(name = "id") @Parameter(description = "id матча") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Добавление футбольного матча", description = "Добавляет новый футбольный матч")
    @PostMapping(value = "/addmatch")
    public ResponseEntity addMatch(@RequestBody MatchDto matchDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Изменение информации о футбольном матче", description = "Изменяет информацию о футбольном матче по указанному id")
    @PutMapping(value = "/editmatch/{id}")
    public ResponseEntity editMatch(@PathVariable(name = "id") @Parameter(description = "id матча") Long id, @RequestBody MatchDto matchDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Удаление футбольного матча", description = "Удаляет футбольный матч по указанному id")
    @DeleteMapping(value = "/deletematch/{id}")
    public ResponseEntity deleteTournament(@PathVariable(name = "id") @Parameter(description = "id матча") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
