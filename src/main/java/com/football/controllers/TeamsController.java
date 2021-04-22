package com.football.controllers;

import com.football.dto.TeamDto;
import com.football.interfaces.TeamInterface;
import com.football.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Controllers of Teams")
@RestController
@RequestMapping(value = "/teams")
public class TeamsController {

    @Autowired
    TeamInterface teamService;

    @GetMapping(value = "/getall")
    public List<TeamDto> getAll() {
        return teamService.findAll();
    }

    @GetMapping(value = "/getone/{id}")
    public TeamDto getOne(@ApiParam(name = "team id", value = "id команды, которую необходимо найти") @PathVariable(name = "id") /*@Parameter(description = "id команды")*/ Long id) {
        return teamService.getOne(id);
    }

    @PostMapping(value = "/add")
    public TeamDto add(@RequestBody @Valid TeamDto teamDto) {
        return teamService.add(teamDto);
    }

    @PutMapping(value = "/edit/{id}")
    public TeamDto edit(@PathVariable(name = "id") Long id, @RequestBody @Valid TeamDto teamDto) {
        return teamService.edit(id, teamDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") Long id) {
        return teamService.delete(id);
    }
}
