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
public class OrderDto implements Serializable {
    private final Long id;
    @Size(max = 255)
    private final String orderTrackingNumber;
    private final BigDecimal totalPrice;
    private final Integer totalQuantity;
    private final AddressDto billingAddress;
    private final AddressDto shippingAddress;
    private final CustomerDto customer;
    @Size(max = 128)
    private final String status;
    private final Instant dateCreated;
    private final Instant lastUpdated;
    private final Set<OrderItemDto> orderItems;
}