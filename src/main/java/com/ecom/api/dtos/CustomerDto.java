package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ecom.api.entities.Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String firstName;
    @Size(max = 255)
    private final String lastName;
    @Size(max = 255)
    private final String email;
}