package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.ecom.api.entities.Product} entity
 */
@Data
public class ProductListDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String name;
    private final BigDecimal unitPrice;
    @Size(max = 255)
    private final String imageUrl;
}