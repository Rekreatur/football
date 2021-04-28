package com.football.interfaces;

import com.football.dto.CityDto;

import java.util.List;

public interface CityInterface {
    List<CityDto> findAll();

    CityDto getOne(Long id);

    CityDto add(CityDto cityDto);

    CityDto edit(Long id, CityDto cityDto);

    CityDto delete(Long id);
}
