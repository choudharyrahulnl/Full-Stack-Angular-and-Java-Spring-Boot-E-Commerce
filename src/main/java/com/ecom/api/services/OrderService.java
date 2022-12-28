package com.ecom.api.services;

import com.ecom.api.dtos.OrderDto;
import com.ecom.api.dtos.OrderListDto;

import java.util.List;

public interface OrderService {

    List<OrderListDto> findOrdersByCustomerEmail(String email, int page, int size);

    OrderDto  findOrderById(Long id);

}
