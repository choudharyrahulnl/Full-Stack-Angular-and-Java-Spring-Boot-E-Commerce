package com.ecom.api.services;

import com.ecom.api.dtos.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> findAll();
}
