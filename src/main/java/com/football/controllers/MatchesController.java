package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.interfaces.MatchInterface;
import com.football.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MatchController", description = "Контроллер, отвечающий за работу с футбольными матчами")
@RestController
@RequestMapping(value = "/matches")
public class MatchesController {
    @Autowired
    MatchInterface matchService;

    @Operation(summary = "Выдача списка матчей", description = "Выдаёт список всех футбольных матчей")
    @GetMapping(value = "/getall")
    public List<MatchDto> getAllMatches() {
        return matchService.findAll();
    }

    @Operation(summary = "Выдача списка матчей турнира", description = "Выдаёт список всех футбольных матчей по указанному турниру")
    @GetMapping(value = "/tournaments/{id}")
    public List<MatchDto> getAllMatchesTournament(@PathVariable(name = "id") @Parameter(description = "Название турнира") Long id) {
        return matchService.finaAllTournament(id);
    }

    @Operation(summary = "Выдача списка матчей команды", description = "Выдаёт список всех футбольных матчей по указанной команде")
    @GetMapping(value = "/teams/{id}")
    public List<MatchDto> getAllMatchesTeam(@PathVariable(name = "id") @Parameter(description = "Название команды") Long id) {
        return matchService.findAllTeam(id);
    }

    @Operation(summary = "Выдача информации о матче", description = "Выдаёт информацию о матче по указанному id")
    @GetMapping(value = "/getone/{id}")
    public MatchDto getOneMatch(@PathVariable(name = "id") @Parameter(description = "id матча") Long id) {
        return matchService.getOne(id);
    }

    @Operation(summary = "Добавление футбольного матча", description = "Добавляет новый футбольный матч")
    @PostMapping(value = "/add")
    public ApiResponse addMatch(@RequestBody @Valid MatchDto matchDto) {
        return matchService.add(matchDto);
    }

    @Operation(summary = "Изменение информации о футбольном матче", description = "Изменяет информацию о футбольном матче по указанному id")
    @PutMapping(value = "/edit/{id}")
    public MatchDto editMatch(@PathVariable(name = "id") @Parameter(description = "id матча") Long id, @RequestBody @Valid MatchDto matchDto) {
        return matchService.edit(id, matchDto);
    }

    @Operation(summary = "Удаление футбольного матча", description = "Удаляет футбольный матч по указанному id")
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteMatch(@PathVariable(name = "id") @Parameter(description = "id матча") Long id) {
        return matchService.delete(id);
    }
}
