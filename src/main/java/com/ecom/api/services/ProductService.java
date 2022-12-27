package com.ecom.api.services;

import com.ecom.api.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    ProductDto update(ProductDto productDto);

    void deleteById(Long id);

    List<ProductDto>  findByCategory(List<Long> id);

    List<ProductDto> findByName(String name, int page, int size);
}
