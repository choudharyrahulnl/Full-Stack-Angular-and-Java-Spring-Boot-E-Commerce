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
        Order order = orderMapper.toEntity(purchaseDto.getOrderDto());

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
        Address billingAddress = addressMapper.toEntity(purchaseDto.getBillingAddressDto());
        Address shippingAddress = addressMapper.toEntity(purchaseDto.getShippingAddressDto());
        order.setBillingAddress(billingAddress);
        order.setShippingAddress(shippingAddress);

        // populate customer with order
        Customer customer = customerMapper.toEntity(purchaseDto.getCustomerDto());

        // check if this is an existing customer
        Customer byEmail = customerRepository.findByEmail(customer.getEmail());
        if (byEmail != null) {
            customer = byEmail;
        }

        // add order to customer
        customer.add(order);

        // save to db
        // in db object will be saved in sequence, depends on foreign key
        // ex order has foreign key for customer, billing & shipping address, so these will be saved first
        // order_item has foreign key for order, order will be saved then and finally order_item
        // in objects we need to just create/set the object graph of customer, address, order, order item
        // hibernate will read relationship mapping and insert as per above db sequence
        // that means we can also save order instead of customer just by adding cascade = CascadeType.ALL
        // on Order Class - Customer Object that mean if you save order then save customer as well
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
