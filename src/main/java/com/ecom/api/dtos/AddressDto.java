package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ecom.api.entities.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String city;
    @Size(max = 255)
    private final String country;
    @Size(max = 255)
    private final String state;
    @Size(max = 255)
    private final String street;
    @Size(max = 255)
    private final String zipCode;
}