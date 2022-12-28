package com.ecom.api.services.impl;

import com.ecom.api.dtos.PurchaseRequestDto;
import com.ecom.api.dtos.PurchaseResponseDto;
import com.ecom.api.entities.Address;
import com.ecom.api.entities.Customer;
import com.ecom.api.entities.Order;
import com.ecom.api.entities.OrderItem;
import com.ecom.api.mappers.AddressMapper;
import com.ecom.api.mappers.CustomerMapper;
import com.ecom.api.mappers.OrderItemListMapper;
import com.ecom.api.mappers.OrderMapper;
import com.ecom.api.repositories.CustomerRepository;
import com.ecom.api.services.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;
    private final OrderItemListMapper orderItemListMapper;
    private final AddressMapper addressMapper;
    private final CustomerMapper customerMapper;

    public CheckoutServiceImpl(CustomerRepository customerRepository, OrderMapper orderMapper, OrderItemListMapper orderItemListMapper, AddressMapper addressMapper, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
        this.orderItemListMapper = orderItemListMapper;
        this.addressMapper = addressMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public PurchaseResponseDto placeOrder(PurchaseRequestDto purchaseDto) {

        // retrieve the order info from dto
        Order order = orderMapper.toEntity(purchaseDto.getOrder());

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with order items
        Set<OrderItem> orderItems = purchaseDto.getOrderItems().stream()
                .map(orderItemListMapper::toEntity)
                .collect(Collectors.toSet());
        orderItems.forEach(orderItem -> order.add(orderItem));

        // set order status
        order.setStatus("CREATED");

        // populate order with billing address & shipping address
        Address billingAddress = addressMapper.toEntity(purchaseDto.getBillingAddress());
        Address shippingAddress = addressMapper.toEntity(purchaseDto.getShippingAddress());
        order.setBillingAddress(billingAddress);
        order.setShippingAddress(shippingAddress);

        // populate customer with order
        Customer customer = customerMapper.toEntity(purchaseDto.getCustomer());
        customer.add(order);

        // save to db
        customerRepository.save(customer);

        // return order tracking number
        return new PurchaseResponseDto(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (Version 4)
        String orderTrackingNumber = UUID.randomUUID().toString();

        // query db to see if UUID is already present ( special case collision )

        // if so, then repeat above 2 steps until no duplicate found

        return orderTrackingNumber;
    }
}
