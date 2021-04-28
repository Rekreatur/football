package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.dto.TournamentDto;
import com.football.interfaces.MatchInterface;
import com.football.interfaces.TournamentInterface;
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
@RequestMapping(value = "/tournaments")
@Api(value = "/tournaments", description = "Контроллер, отвечающий за работу с футбольными турнирами")
public class TournamentsController {
    @Autowired
    TournamentInterface tournamentService;
    @Autowired
    MatchInterface matchService;

    @ApiOperation(value = "Выдача списка футбольных турниров", notes = "Выдаёт список всех футбольных турниров", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка турниров прошла успешно"))
    @GetMapping(value = "/getall")
    public ApiResponse<List<TournamentDto>> getAll() {
        return tournamentService.findAll();
    }

    @ApiOperation(value = "Выдача информации о футбольном турнире", notes = "Выдаёт информацию о футбольном турнире по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача турнира по его id прошла успешно"))
    @GetMapping(value = "/getone/{id}")
    public ApiResponse<TournamentDto> getOne(@ApiParam(name = "tournament id", value = "id турнира, который необходимо найти") @PathVariable(name = "id") Long id) {
        return tournamentService.getOne(id);
    }

    @ApiOperation(value = "Выдача списка матчей турнира", notes = "Выдаёт список всех матчей турнира по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка матчей турнира прошла успешно"))
    @GetMapping(value = "/matches/{id}")
    public ApiResponse<List<MatchDto>> getAllMatchesTournament(@ApiParam(name = "tournament id", value = "id тунира, по которому нужно найти матчи")@PathVariable(name = "id") Long id) {
        return matchService.finaAllTournament(id);
    }

    @ApiOperation(value = "Добавление футбольного турнира", notes = "Добавляет новый футбольный турнир", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Добавление турнира прошло успешно"))
    @PostMapping(value = "/add")
    public ApiResponse add(@ApiParam(name = "Tournament Entity", value = "Турнир, который необходимо добавить") @RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.add(tournamentDto);
    }

    @ApiOperation(value = "Изменение информации о футбольном турнире", notes = "Изменяет информацию о турнире по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Редактирование турнира прошло успешно"))
    @PutMapping(value = "/{id}")
    public ApiResponse editTournament(@ApiParam(name = "tournament id", value = "id турнира, который необходимо изменить") @PathVariable(name = "id") Long id,
                                      @ApiParam(name = "Tournament Entity", value = "Информация о турнире, которую необходимо внести в изменения") @RequestBody @Valid TournamentDto tournamentDto) {
        return tournamentService.edit(id, tournamentDto);
    }

    @ApiOperation(value = "Удаление турнира", notes = "Удаляет турнир по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Удаление турнира прошло успешно"))
    @DeleteMapping(value = "/{id}")
    public ApiResponse deleteTournament(@ApiParam(name = "tournament id", value = "id турнира, который необходимо удалить") @PathVariable(name = "id") Long id) {
        return tournamentService.delete(id);
    }
}
