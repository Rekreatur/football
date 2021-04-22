package com.football.controllers;

import com.football.dto.MatchDto;
import com.football.interfaces.MatchInterface;
import com.football.response.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/matches")
public class MatchesController {
    @Autowired
    MatchInterface matchService;

    @GetMapping(value = "/getall")
    public List<MatchDto> getAllMatches() {
        return matchService.findAll();
    }

    @GetMapping(value = "/tournaments/{id}")
    public List<MatchDto> getAllMatchesTournament(@PathVariable(name = "id") Long id) {
        return matchService.finaAllTournament(id);
    }

    @GetMapping(value = "/teams/{id}")
    public List<MatchDto> getAllMatchesTeam(@PathVariable(name = "id") Long id) {
        return matchService.findAllTeam(id);
    }

    @GetMapping(value = "/getone/{id}")
    public MatchDto getOneMatch(@PathVariable(name = "id") Long id) {
        return matchService.getOne(id);
    }

    @PostMapping(value = "/add")
    public ApiResponse addMatch(@RequestBody @Valid MatchDto matchDto) {
        return matchService.add(matchDto);
    }

    @PutMapping(value = "/edit/{id}")
    public MatchDto editMatch(@PathVariable(name = "id") Long id, @RequestBody @Valid MatchDto matchDto) {
        return matchService.edit(id, matchDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteMatch(@PathVariable(name = "id") Long id) {
        return matchService.delete(id);
    }
}
