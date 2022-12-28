package com.ecom.api.dtos;

import com.ecom.api.entities.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.ecom.api.entities.OrderItem} entity
 */
@Data
public class OrderItemDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String imageUrl;
    private final Integer quantity;
    private final BigDecimal unitPrice;
    @NotNull
    private final ProductDto product;
}