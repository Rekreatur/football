package com.football.converter;

import com.football.domain.City;
import com.football.dto.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityConverter {
    public CityDto entityToDto(City city) {
        return new CityDto(city.getId(), city.getName());
    }

    public List<CityDto> entityToDto(List<City> cities) {
        return cities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public City dtoToEntity(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        return city;
    }

    public List<City> dtoToEntity(List<CityDto> cityDtos) {
        return cityDtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    public City dtoToEntityEdit(City city, CityDto cityDto) {
        city.setName(cityDto.getName());
        return city;
    }
}
