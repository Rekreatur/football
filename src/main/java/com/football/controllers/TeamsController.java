package com.football.controllers;

import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import com.football.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Controllers of Teams")
//@Tag(name = "TeamController", description = "Контроллер, отвечающий за работу с футбольными командами")
@RestController
@RequestMapping(value = "/teams")
public class TeamsController {

    @Autowired
    TeamInterface teamService;

    //@ApiOperation(value = "Выдача списка футбольных команд", notes = "Выдаёт список всех футбольных команд")
    @Operation(summary = "Выдача списка футбольных команд", description = "Выдаёт список всех футбольных команд")
    @GetMapping(value = "/getall")
    public List<TeamDto> getAll() {
        return teamService.findAll();
    }

    //@ApiOperation(value = "Выдача информации о футбольной команде", notes = "Выдаёт информацию о футбольной команде по указанному id", response = TeamDto.class)
    @Operation(summary = "Выдача информации о футбольной команде", description = "Выдаёт информацию о футбольной команде по указанному id")
    @GetMapping(value = "/getone/{id}")
    public TeamDto getOne(@ApiParam(name = "team id", value = "id команды, которую необходимо найти") @PathVariable(name = "id") /*@Parameter(description = "id команды")*/ Long id) {
        return teamService.getOne(id);
    }

    @Operation(summary = "Добавление футбольной команды", description = "Добавляет новую футбольную команду")
    @PostMapping(value = "/add")
    public TeamDto add(@RequestBody @Valid TeamDto teamDto) {
        return teamService.add(teamDto);
    }

    @Operation(summary = "Изменение информации о футбольной команде", description = "Изменяет информацию о футбольной команде по указанному id")
    @PutMapping(value = "/edit/{id}")
    public TeamDto edit(@PathVariable(name = "id") @Parameter(description = "id команды") Long id, @RequestBody @Valid TeamDto teamDto) {
        return teamService.edit(id, teamDto);
    }

    @Operation(summary = "Удаление футбольной команды", description = "Удаляет футбольную команду по указанному id")
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") @Parameter(description = "id команды") Long id) {
        return teamService.delete(id);
    }
}
