package com.football.controllers;

import com.football.dto.CityDto;
import com.football.interfaces.CityInterface;
import com.football.response.ApiResponse;
import com.football.response.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
@Api(value = "/cities", description = "Контроллер, отвечающий за работу с городами")
public class CityController {
    final CityInterface cityService;

    public CityController(CityInterface cityService) {
        this.cityService = cityService;
    }

    @ApiOperation(value = "Выдача списка городов", notes = "Выдаёт список всех городов", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача списка городов прошла успешно"))
    @GetMapping(value = "/getall")
    public ApiResponse<List<CityDto>> getAll() {
        return new ApiResponse<>("The list was issued successfully", Status.OK, cityService.findAll());
    }

    @ApiOperation(value = "Выдача информации городе", notes = "Выдаёт информацию о городе по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Выдача города по id прошла успешно"))
    @GetMapping(value = "/getone/{id}")
    public ApiResponse<CityDto> getOne(@ApiParam(name = "city id", value = "id города, которую необходимо найти") @PathVariable(name = "id") Long id) {
        return new ApiResponse<>("The city issued successfully", Status.OK, cityService.getOne(id));
    }

    @ApiOperation(value = "Добавление города", notes = "Добавляет новый город", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Добавление города прошло успешно"))
    @PostMapping(value = "/add")
    public ApiResponse<CityDto> add(@ApiParam(name = "City Entity", value = "Город, который необходимо добавить") @RequestBody @Valid CityDto cityDto) {
        return new ApiResponse<>("The city added successfully", Status.OK, cityService.add(cityDto));
    }

    @ApiOperation(value = "Изменение информации о городе", notes = "Изменяет информацию о городе по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Редактирование города прошло успешно"))
    @PutMapping(value = "/{id}")
    public ApiResponse<CityDto> edit(@ApiParam(name = "city id", value = "id города, который необходимо изменить") @PathVariable(name = "id") Long id,
                                     @ApiParam(name = "City Entity", value = "Информация о городе, которую необходимо внести в изменения") @RequestBody @Valid CityDto cityDto) {
        return new ApiResponse<>("The city edited successfully", Status.OK, cityService.edit(id, cityDto));
    }

    @ApiOperation(value = "Удаление города", notes = "Удаляет город по указанному id", response = ApiResponse.class)
    @ApiResponses(value = @io.swagger.annotations.ApiResponse(code = 200, message = "Удаление города прошло успешно"))
    @DeleteMapping(value = "/{id}")
    public ApiResponse<CityDto> delete(@ApiParam(name = "city id", value = "id города, который необходимо удалить") @PathVariable(name = "id") Long id) {
        return new ApiResponse<>("Delete successfully", Status.OK, cityService.delete(id));
    }

}
