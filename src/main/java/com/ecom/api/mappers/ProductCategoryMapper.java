package com.ecom.api.mappers;

import com.ecom.api.dtos.ProductCategoryDto;
import com.ecom.api.dtos.ProductDto;
import com.ecom.api.entities.Product;
import com.ecom.api.entities.ProductCategory;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategory toEntity(ProductCategoryDto productCategoryDto);

    ProductCategoryDto toDto(ProductCategory productCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductCategory partialUpdate(ProductCategoryDto productCategoryDto, @MappingTarget ProductCategory productCategory);
}