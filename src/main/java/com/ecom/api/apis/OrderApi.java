package com.ecom.api.apis;

import com.ecom.api.dtos.OrderDto;
import com.ecom.api.dtos.OrderListDto;
import com.ecom.api.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderApi {

    private final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderListDto>> findOrdersByEmail(@RequestParam("email") String email,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size) {
        return new ResponseEntity<>(orderService.findOrdersByCustomerEmail(email, page, size), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findOrderByEmail(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }
}
