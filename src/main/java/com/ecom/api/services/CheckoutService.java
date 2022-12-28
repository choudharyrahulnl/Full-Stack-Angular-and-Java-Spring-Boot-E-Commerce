package com.ecom.api.services;

import com.ecom.api.dtos.PurchaseRequestDto;
import com.ecom.api.dtos.PurchaseResponseDto;

public interface CheckoutService {

    PurchaseResponseDto placeOrder(PurchaseRequestDto purchaseDto);
}
