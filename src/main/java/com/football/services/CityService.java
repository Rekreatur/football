package com.football.services;

import com.football.converter.CityConverter;
import com.football.domain.City;
import com.football.dto.CityDto;
import com.football.interfaces.CityInterface;
import com.football.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService implements CityInterface {

    final CityConverter cityConverter;
    final CityRepository cityRepository;

    public CityService(CityConverter cityConverter, CityRepository cityRepository) {
        this.cityConverter = cityConverter;
        this.cityRepository = cityRepository;
    }

    public List<CityDto> findAll() {
        List<CityDto> cityDtos = new ArrayList<>();
        cityRepository.findAll().forEach(x -> cityDtos.add(cityConverter.entityToDto(x)));
        return cityDtos;
    }

    public Optional<CityDto> getOne(Long id) {
        if(!cityRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(cityConverter.entityToDto(cityRepository.findById(id).get()));
    }

    public CityDto add(CityDto cityDto) {
        return cityConverter.entityToDto(cityRepository.save(cityConverter.dtoToEntity(cityDto)));
    }

    public Optional<CityDto> edit(Long id, CityDto cityDto) {
        if(!cityRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        cityConverter.dtoToEntityEdit(cityRepository.findById(id).get(),cityDto);
        return Optional.of(cityConverter.entityToDto(cityRepository.save(cityRepository.findById(id).get())));
    }

    public Optional<CityDto> delete(Long id) {
        if(!cityRepository.findById(id).isPresent()) {
            return Optional.empty();
        }
        CityDto cityDto = cityConverter.entityToDto(cityRepository.findById(id).get());
        cityRepository.delete(cityRepository.findById(id).get());
        return Optional.of(cityDto);
    }
}
