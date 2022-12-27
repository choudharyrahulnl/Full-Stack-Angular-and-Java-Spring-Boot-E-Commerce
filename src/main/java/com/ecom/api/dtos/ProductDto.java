package com.ecom.api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.ecom.api.entities.Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String sku;
    @Size(max = 255)
    private final String name;
    @Size(max = 255)
    private final String description;
    private final BigDecimal unitPrice;
    @Size(max = 255)
    private final String imageUrl;
    private final Boolean active;
    private final Integer unitsInStock;
    private final Instant dateCreated;
    private final Instant lastUpdated;
    @NotNull
    private final ProductCategoryDto category;
}