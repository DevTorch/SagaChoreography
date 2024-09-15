package com.github.devtorch.saga.orderservice.domain.dto.mapper;

import com.github.devtorch.saga.orderservice.domain.OrderItem;
import com.github.devtorch.saga.orderservice.domain.dto.item.OrderItemRequestDto;
import com.github.devtorch.saga.orderservice.domain.dto.item.OrderItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemResponseDto toOrderItemResponseDto(OrderItem orderItem);

    Set<OrderItemRequestDto> toOrderItemRequestDtoSet(Set<OrderItem> orderItems);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderId", ignore = true)
    OrderItem toOrderItemEntity(OrderItemRequestDto orderItemRequestDto);
}
