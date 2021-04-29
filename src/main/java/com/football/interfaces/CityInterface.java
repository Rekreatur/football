package com.football.interfaces;

import com.football.dto.CityDto;

import java.util.List;
import java.util.Optional;

public interface CityInterface {
    List<CityDto> findAll();

    Optional<CityDto> getOne(Long id);

    CityDto add(CityDto cityDto);

    Optional<CityDto> edit(Long id, CityDto cityDto);

    Optional<CityDto> delete(Long id);
}
