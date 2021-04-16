package com.football.controllers;

import com.football.dto.TeamDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TeamController", description = "Контроллер, отвечающий за работу с футбольными командами")
@RestController
@RequestMapping(value = "/football")
public class TeamsController {

    @Operation(summary = "Выдача списка футбольных команд", description = "Выдаёт список всех футбольных команд")
    @GetMapping(value = "/teams")
    public ResponseEntity getAllTeams() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Выдача информации о футбольной команде", description = "Выдаёт информацию о футбольной команде по указанному id")
    @GetMapping(value = "/teams/{id}")
    public ResponseEntity getOneTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Добавление футбольной команды", description = "Добавляет новую футбольную команду")
    @PostMapping(value = "/addteam")
    public ResponseEntity addTeam(@RequestBody TeamDto teamDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Изменение информации о футбольной команде", description = "Изменяет информацию о футбольной команде по указанному id")
    @PutMapping(value = "/editteam/{id}")
    public ResponseEntity editTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id, @RequestBody TeamDto teamDto) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Удаление футбольной команды", description = "Удаляет футбольную команду по указанному id")
    @DeleteMapping(value = "/deleteteam/{id}")
    public ResponseEntity deleteTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
