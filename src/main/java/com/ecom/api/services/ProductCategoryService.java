package com.ecom.api.services;

import com.ecom.api.dtos.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> findAll();
}
