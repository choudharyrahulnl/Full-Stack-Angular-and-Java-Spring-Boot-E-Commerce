package com.ecom.api.mappers;

import com.ecom.api.dtos.OrderDto;
import com.ecom.api.dtos.OrderListDto;
import com.ecom.api.entities.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderListMapper {
    Order toEntity(OrderListDto orderDto);

    OrderListDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order partialUpdate(OrderListDto orderDto, @MappingTarget Order order);
}