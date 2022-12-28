package com.ecom.api.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class PurchaseRequestDto {

    private CustomerDto customer;
    private AddressDto shippingAddress;
    private AddressDto billingAddress;
    private OrderDto order;
    private Set<OrderItemDto> orderItems;

}
