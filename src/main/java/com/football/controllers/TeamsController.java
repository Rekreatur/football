package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.dto.TeamDto;
import com.football.interfaces.MatchInterface;
import com.football.interfaces.TeamInterface;
import com.football.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/teams")
@Api(value = "/teams", description = "Контроллер, отвечающий за работу с футбольными командами")
public class TeamsController {

    @Autowired
    TeamInterface teamService;

    @Autowired
    MatchInterface matchService;

    @ApiOperation(value = "Выдача списка футбольных команд", notes = "Выдаёт список всех футбольных команд", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка команд прошла успешно"))
    @GetMapping(value = "/getall")
    public ApiResponse<List<TeamDto>> getAll() {
        return teamService.findAll();
    }

    @ApiOperation(value = "Выдача информации о футбольной команде", notes = "Выдаёт информацию о футбольной команде по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача команды по её id прошла успешно"))
    @GetMapping(value = "/getone/{id}")
    public ApiResponse<TeamDto> getOne(@ApiParam(name = "team id", value = "id команды, которую необходимо найти") @PathVariable(name = "id") Long id) {
        return teamService.getOne(id);
    }

    @ApiOperation(value = "Выдача списка матчей команды", notes = "Выдаёт список всех матчей команды по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка матчей команды прошла успешно"))
    @GetMapping(value = "/matches/{id}")
    public ApiResponse<List<MatchDto>> getAllMatchesTeam(@ApiParam(name = "team id", value = "id команды, по которой нужно найти матчи") @PathVariable(name = "id") Long id) {
        return matchService.findAllTeam(id);
    }

    @ApiOperation(value = "Добавление футбольной команды", notes = "Добавляет новую футбольную команду", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Добавление команды прошло успешно"))
    @PostMapping(value = "/add")
    public ApiResponse add(@ApiParam(name = "Team Entity", value = "Команда, которую необходимо добавить") @RequestBody @Valid TeamDto teamDto) {
        return teamService.add(teamDto);
    }

    @ApiOperation(value = "Изменение информации о футбольной команде", notes = "Изменяет информацию о футбольной команде по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Редактирование команды прошло успешно"))
    @PutMapping(value = "/{id}")
    public ApiResponse edit(@ApiParam(name = "team id", value = "id команды, которую необходимо изменить") @PathVariable(name = "id") Long id,
                        @ApiParam(name = "Team Entity", value = "Информация о команде, которую необходимо внести в изменения") @RequestBody @Valid TeamDto teamDto) {
        return teamService.edit(id, teamDto);
    }

    @ApiOperation(value = "Удаление футбольной команды", notes = "Удаляет футбольную команду по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Удаление команды прошло успешно"))
    @DeleteMapping(value = "/{id}")
    public ApiResponse delete(@ApiParam(name = "team id", value = "id команды, которую необходимо удалить") @PathVariable(name = "id") Long id) {
        return teamService.delete(id);
    }
}
