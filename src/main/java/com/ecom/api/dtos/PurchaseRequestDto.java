package com.ecom.api.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class PurchaseRequestDto {

    private CustomerDto customerDto;
    private AddressDto shippingAddressDto;
    private AddressDto billingAddressDto;
    private OrderDto orderDto;
    private Set<OrderItemDto> orderItems;

}
