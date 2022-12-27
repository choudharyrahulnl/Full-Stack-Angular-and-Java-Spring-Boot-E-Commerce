package com.ecom.api.services.impl;

import com.ecom.api.dtos.ProductDto;
import com.ecom.api.entities.Product;
import com.ecom.api.entities.ProductCategory;
import com.ecom.api.exceptions.ProductNotFoundException;
import com.ecom.api.mappers.ProductMapper;
import com.ecom.api.repositories.ProductCategoryRepository;
import com.ecom.api.repositories.ProductRepository;
import com.ecom.api.services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.    Collectors;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto findById(Long id) {
        try {
            Product productEntity = productRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            return productMapper.toDto(productEntity);
        } catch (EntityNotFoundException ex) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("Products not found");
        }
        return productList.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if(productDto.getId() == null) {
            throw new IllegalArgumentException("Product ID is missing");
        }
        Product productEntity = productRepository.findById(productDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(productEntity.getCategory().getId());
        if(productCategory.isPresent()) {
            productEntity.setCategory(productCategory.get());
        }
        productMapper.partialUpdate(productDto, productEntity);
        return productMapper.toDto(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        try {
            Product productEntity = productRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            if (productEntity.getId() != null) {
                productRepository.deleteById(id);
            }
        } catch (EntityNotFoundException ex) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
    }

    @Override
    public List<ProductDto> findByCategory(List<Long> id) {
        List<Product> productList = productRepository.findProductByCategory(id);
        if(productList.isEmpty()){
            throw new ProductNotFoundException("Product with Categories " + id +" not found");
        }
        return productList.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByName(String name, int page, int size) {
        Page<Product> productList = productRepository.findProductByNameContaining(name, PageRequest.of(page, size) );
        if(productList.isEmpty()) {
            throw new ProductNotFoundException("Product with Name " + name +" not found");
        }
        return productList.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
