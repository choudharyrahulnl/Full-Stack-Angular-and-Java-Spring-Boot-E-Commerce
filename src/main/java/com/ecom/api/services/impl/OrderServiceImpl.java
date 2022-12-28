package com.ecom.api.services.impl;

import com.ecom.api.dtos.OrderDto;
import com.ecom.api.dtos.OrderListDto;
import com.ecom.api.entities.Order;
import com.ecom.api.exceptions.OrdersNotFoundException;
import com.ecom.api.mappers.OrderListMapper;
import com.ecom.api.mappers.OrderMapper;
import com.ecom.api.repositories.OrderRepository;
import com.ecom.api.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderListMapper orderListMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderListMapper orderListMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderListMapper = orderListMapper;
    }

    @Override
    public List<OrderListDto> findOrdersByCustomerEmail(String email, int page, int size) {
        Page<Order> byCustomerEmail = orderRepository.findByCustomerEmail(email, PageRequest.of(page, size));
        if(byCustomerEmail.isEmpty()) {
            throw new OrdersNotFoundException("Orders not found with email " + email);
        }
        return byCustomerEmail.stream().map(orderListMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        if(!byId.isPresent()) {
            throw new OrdersNotFoundException("Order not found with id " + id);
        }
        return orderMapper.toDto(byId.get());
    }
}
