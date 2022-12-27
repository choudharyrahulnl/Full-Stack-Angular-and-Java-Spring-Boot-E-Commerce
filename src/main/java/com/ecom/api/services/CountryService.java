package com.ecom.api.services;

import com.ecom.api.dtos.CountryDto;
import com.ecom.api.dtos.CountryListDto;

import java.util.List;

public interface CountryService {

    List<CountryListDto> findAll();
    CountryDto findById(Integer id);
}
