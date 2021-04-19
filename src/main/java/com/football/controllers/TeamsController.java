package com.football.controllers;

import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TeamController", description = "Контроллер, отвечающий за работу с футбольными командами")
@RestController
@RequestMapping(value = "/football")
public class TeamsController {

    @Autowired
    TeamInterface teamService;

    @Operation(summary = "Выдача списка футбольных команд", description = "Выдаёт список всех футбольных команд")
    @GetMapping(value = "/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.findAll();
    }

    @Operation(summary = "Выдача информации о футбольной команде", description = "Выдаёт информацию о футбольной команде по указанному id")
    @GetMapping(value = "/teams/{id}")
    public TeamDto getOneTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id) {
        return teamService.getOneTeam(id);
    }

    @Operation(summary = "Добавление футбольной команды", description = "Добавляет новую футбольную команду")
    @PostMapping(value = "/addteam")
    public TeamDto addTeam(@RequestBody TeamDto teamDto) {
        return teamService.addTeam(teamDto);
    }

    @Operation(summary = "Изменение информации о футбольной команде", description = "Изменяет информацию о футбольной команде по указанному id")
    @PutMapping(value = "/editteam/{id}")
    public TeamDto editTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id, @RequestBody TeamDto teamDto) {
        return teamService.edit(id, teamDto);
    }

    @Operation(summary = "Удаление футбольной команды", description = "Удаляет футбольную команду по указанному id")
    @DeleteMapping(value = "/deleteteam/{id}")
    public void deleteTeam(@PathVariable(name = "id") @Parameter(description = "id команды") Long id) {
        teamService.delete(id);
    }
}
