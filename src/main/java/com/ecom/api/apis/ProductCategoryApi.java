package com.ecom.api.apis;

import com.ecom.api.dtos.ProductCategoryDto;
import com.ecom.api.entities.ProductCategory;
import com.ecom.api.services.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product-category")
public class ProductCategoryApi {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryApi(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> findAll() {
        return new ResponseEntity<>(productCategoryService.findAll(), HttpStatus.OK);
    }
}
