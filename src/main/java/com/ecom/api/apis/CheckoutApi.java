package com.ecom.api.apis;

import com.ecom.api.dtos.PurchaseRequestDto;
import com.ecom.api.dtos.PurchaseResponseDto;
import com.ecom.api.services.CheckoutService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
public class CheckoutApi {

    private final CheckoutService checkoutService;

    public CheckoutApi(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDto> checkout(@RequestBody @NotNull @Valid PurchaseRequestDto purchaseRequestDto) {
        return new ResponseEntity<>(checkoutService.placeOrder(purchaseRequestDto), HttpStatus.OK);
    }
}
