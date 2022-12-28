package com.ecom.api.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.ecom.api.entities.Order} entity
 */
@Data
public class OrderListDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String orderTrackingNumber;
    private final BigDecimal totalPrice;
    private final Integer totalQuantity;
}