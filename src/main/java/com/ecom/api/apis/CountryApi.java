package com.ecom.api.apis;

import com.ecom.api.dtos.CountryDto;
import com.ecom.api.dtos.CountryListDto;
import com.ecom.api.services.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/countries")
public class CountryApi {

    private final CountryService countryService;

    public CountryApi(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryListDto>> findAll() {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }
}
