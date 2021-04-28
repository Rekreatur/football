package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.interfaces.MatchInterface;
import com.football.response.ApiResponse;
import java.util.List;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/matches")
@Api(value = "/matches", description = "Контроллер, отвечающий за работу с футбольными матчами")
public class MatchesController {
    @Autowired
    MatchInterface matchService;

    @ApiOperation(value = "Выдача списка матчей", notes = "Выдаёт список всех футбольных матчей", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка футбольных матчей прошла успешно"))
    @GetMapping(value = "/getall")
    public ApiResponse<List<MatchDto>> getAllMatches() {
        return matchService.findAll();
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
    @PutMapping(value = "/{id}")
    public ApiResponse editMatch(@ApiParam(name = "match id", value = "id матча, который необходимо изменить")@PathVariable(name = "id") Long id,
                                 @ApiParam(name = "Match Entity", value = "Информация о матче, которую необхожимо внести в изменения")@RequestBody @Valid MatchDto matchDto) {
        return matchService.edit(id, matchDto);
    }

    @ApiOperation(value = "Удаление футбольного матча", notes = "Удаляет футбольный матч по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Удаление матча прошло успешно"))
    @DeleteMapping(value = "/{id}")
    public ApiResponse deleteMatch(@ApiParam(name = "match id", value = "id матча, который необходимо удалить")@PathVariable(name = "id") Long id) {
        return matchService.delete(id);
    }
}
