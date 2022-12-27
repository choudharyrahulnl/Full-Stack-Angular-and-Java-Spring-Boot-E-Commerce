package com.ecom.api.apis;

import com.ecom.api.dtos.ProductDto;
import com.ecom.api.dtos.ProductListDto;
import com.ecom.api.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody @NotNull @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable @NotNull Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductListDto>> findAll(@RequestParam("page") int page,
                                                        @RequestParam("size") int size) {
        return new ResponseEntity<>(productService.findAll(page, size), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<ProductDto> update(@RequestBody @NotNull @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.update(productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @NotNull Long id) {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/find-by-category")
    public ResponseEntity<List<ProductDto>> findByCategory(@RequestParam("id") List<Long> id) {
        return new ResponseEntity<>(productService.findByCategory(id), HttpStatus.OK);
    }

    @GetMapping("/search/find-by-name")
    public ResponseEntity<List<ProductDto>> findByName(@RequestParam("name") String name,
                                                       @RequestParam("page") int page,
                                                       @RequestParam("size") int size) {
        return new ResponseEntity<>(productService.findByName(name, page, size), HttpStatus.OK);
    }
}
