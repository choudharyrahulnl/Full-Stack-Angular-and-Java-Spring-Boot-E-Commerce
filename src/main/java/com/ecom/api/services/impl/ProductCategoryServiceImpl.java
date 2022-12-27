package com.ecom.api.services.impl;

import com.ecom.api.dtos.ProductCategoryDto;
import com.ecom.api.entities.ProductCategory;
import com.ecom.api.exceptions.ProductCategoryNotFoundException;
import com.ecom.api.mappers.ProductCategoryMapper;
import com.ecom.api.repositories.ProductCategoryRepository;
import com.ecom.api.services.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();
        if(productCategoryList.isEmpty()){
            throw new ProductCategoryNotFoundException("ProductCategory not found");
        }
        return productCategoryList.stream()
                .map(productCategoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
