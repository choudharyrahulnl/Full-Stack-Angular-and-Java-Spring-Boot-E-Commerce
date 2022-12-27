package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.ecom.api.entities.Country} entity
 */
@Data
public class CountryDto implements Serializable {
    private final Integer id;
    @Size(max = 2)
    private final String code;
    @Size(max = 255)
    private final String name;
}