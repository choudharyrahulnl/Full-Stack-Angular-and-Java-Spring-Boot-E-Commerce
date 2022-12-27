package com.ecom.api.mappers;

import com.ecom.api.dtos.ProductListDto;
import com.ecom.api.entities.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductListMapper {
    Product toEntity(ProductListDto productListDto);

    ProductListDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductListDto productListDto, @MappingTarget Product product);
}