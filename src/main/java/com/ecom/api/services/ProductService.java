package com.ecom.api.services;

import com.ecom.api.dtos.ProductDto;
import com.ecom.api.dtos.ProductListDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto findById(Long id);

    List<ProductListDto> findAll(int page, int size);

    ProductDto update(ProductDto productDto);

    void deleteById(Long id);

    List<ProductDto>  findByCategory(List<Long> id);

    List<ProductDto> findByName(String name, int page, int size);
}
