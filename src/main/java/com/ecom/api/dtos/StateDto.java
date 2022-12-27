package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ecom.api.entities.State} entity
 */
@Data
public class StateDto implements Serializable {
    private final Integer id;
    @Size(max = 255)
    private final String name;
}