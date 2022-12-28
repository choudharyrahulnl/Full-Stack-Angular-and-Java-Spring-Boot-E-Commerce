package com.ecom.api.services.impl;

import com.ecom.api.dtos.CountryDto;
import com.ecom.api.dtos.CountryListDto;
import com.ecom.api.entities.Country;
import com.ecom.api.exceptions.CountryNotFoundException;
import com.ecom.api.mappers.CountryListMapper;
import com.ecom.api.mappers.CountryMapper;
import com.ecom.api.repositories.CountryRepository;
import com.ecom.api.services.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryListMapper countryListMapper;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository,
                              CountryListMapper countryListMapper, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryListMapper = countryListMapper;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryListDto> findAll() {
        List<Country> countryList = countryRepository.findAll();
        if(countryList.isEmpty()){
            throw new CountryNotFoundException("Countries not found");
        }
        return countryList.stream()
                .map(countryListMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto findById(Integer id) {
        try {
            Country countryEntity = countryRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            return countryMapper.toDto(countryEntity);
        } catch (EntityNotFoundException ex) {
            throw new CountryNotFoundException("Country with ID " + id + " not found");
        }
    }
}
