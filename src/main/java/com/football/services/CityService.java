package com.football.services;

import com.football.converter.CityConverter;
import com.football.domain.City;
import com.football.dto.CityDto;
import com.football.interfaces.CityInterface;
import com.football.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityService implements CityInterface {

    final CityConverter cityConverter;
    final CityRepository cityRepository;

    public CityService(CityConverter cityConverter, CityRepository cityRepository) {
        this.cityConverter = cityConverter;
        this.cityRepository = cityRepository;
    }

    public List<CityDto> findAll() {
        return cityConverter.entityToDto(cityRepository.findAll());
    }

    public CityDto getOne(Long id) {
        return cityConverter.entityToDto(cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
    }

    public CityDto add(CityDto cityDto) {
        return cityConverter.entityToDto(cityRepository.saveAndFlush(cityConverter.dtoToEntity(cityDto)));
    }

    public CityDto edit(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        cityConverter.dtoToEntityEdit(city,cityDto);
        return cityConverter.entityToDto(cityRepository.saveAndFlush(city));
    }

    public CityDto delete(Long id) {
        CityDto cityDto = cityConverter.entityToDto(cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        cityRepository.delete(cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString())));
        return cityDto;
    }
}
