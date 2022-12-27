package com.ecom.api.services.impl;

import com.ecom.api.dtos.CountryDto;
import com.ecom.api.dtos.ProductCategoryDto;
import com.ecom.api.entities.Country;
import com.ecom.api.entities.ProductCategory;
import com.ecom.api.exceptions.CountryNotFoundException;
import com.ecom.api.exceptions.ProductCategoryNotFoundException;
import com.ecom.api.mappers.CountryMapper;
import com.ecom.api.repositories.CountryRepository;
import com.ecom.api.services.CountryService;
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
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDto> findAll() {
        List<Country> countryList = countryRepository.findAll();
        if(countryList.isEmpty()){
            throw new CountryNotFoundException("Countries not found");
        }
        return countryList.stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList());
    }
}
