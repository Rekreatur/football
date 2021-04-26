package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.interfaces.MatchInterface;
import com.football.response.ApiResponse;
import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/matches")
public class MatchesController {
    @Autowired
    MatchInterface matchService;

    @ApiOperation(value = "Выдача списка матчей", notes = "Выдаёт список всех футбольных матчей", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка футбольных матчей прошла успешно"))
    @GetMapping(value = "/getall")
    public ApiResponse<List<MatchDto>> getAllMatches() {
        return matchService.findAll();
    }

    @ApiOperation(value = "Выдача списка матчей турнира", notes = "Выдаёт список всех матчей турнира по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка матчей турнира прошла успешно"))
    @GetMapping(value = "/tournaments/{id}")
    public ApiResponse<List<MatchDto>> getAllMatchesTournament(@ApiParam(name = "tournament id", value = "id тунира, по которому нужно найти матчи")@PathVariable(name = "id") Long id) {
        return matchService.finaAllTournament(id);
    }

    @ApiOperation(value = "Выдача списка матчей команды", notes = "Выдаёт список всех матчей команды по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка матчей команды прошла успешно"))
    @GetMapping(value = "/teams/{id}")
    public ApiResponse<List<MatchDto>> getAllMatchesTeam(@ApiParam(name = "team id", value = "id команды, по которой нужно найти матчи") @PathVariable(name = "id") Long id) {
        return matchService.findAllTeam(id);
    }

    @ApiOperation(value = "Выдача информации о матче", notes = "Выдаёт информацию о матче по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача матча по его id прошла успешно"))
    @GetMapping(value = "/getone/{id}")
    public ApiResponse<MatchDto> getOneMatch(@ApiParam(name = "match id", value = "id матча, который необходимо найти") @PathVariable(name = "id") Long id) {
        return matchService.getOne(id);
    }

    @ApiOperation(value = "Добавление футбольного матча", notes = "Добавляет новый футбольный матч", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = ""))
    @PostMapping(value = "/add")
    public ApiResponse addMatch(@ApiParam(name = "Match Entity", value = "Матч, который необходимо добавить") @RequestBody @Valid MatchDto matchDto) {
        return matchService.add(matchDto);
    }

    @ApiOperation(value = "Изменение информации о футбольном матче", notes = "Изменяет информацию о футбольном матче по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Редактирование матча прошло успешно"))
    @PutMapping(value = "/edit/{id}")
    public ApiResponse editMatch(@ApiParam(name = "match id", value = "id матча, который необходимо изменить")@PathVariable(name = "id") Long id,
                                 @ApiParam(name = "Match Entity", value = "Информация о матче, которую необхожимо внести в изменения")@RequestBody @Valid MatchDto matchDto) {
        return matchService.edit(id, matchDto);
    }

    @ApiOperation(value = "Удаление футбольного матча", notes = "Удаляет футбольный матч по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Удаление матча прошло успешно"))
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteMatch(@ApiParam(name = "match id", value = "id матча, который необходимо удалить")@PathVariable(name = "id") Long id) {
        return matchService.delete(id);
    }
}
