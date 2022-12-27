package com.ecom.api.mappers;

import com.ecom.api.dtos.CountryDto;
import com.ecom.api.entities.Country;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);

//    @AfterMapping
//    default void linkStates(@MappingTarget Country country) {
//        country.getStates().forEach(state -> state.setCountry(country));
//    }
}