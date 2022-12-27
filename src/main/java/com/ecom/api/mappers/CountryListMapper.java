package com.ecom.api.mappers;

import com.ecom.api.dtos.CountryListDto;
import com.ecom.api.entities.Country;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountryListMapper {
    Country toEntity(CountryListDto countryListDto);

    CountryListDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryListDto countryListDto, @MappingTarget Country country);

}