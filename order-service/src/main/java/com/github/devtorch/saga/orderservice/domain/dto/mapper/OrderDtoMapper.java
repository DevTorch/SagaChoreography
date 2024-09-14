package com.github.devtorch.saga.orderservice.domain.dto.mapper;

import com.github.devtorch.saga.orderservice.domain.Order;
import com.github.devtorch.saga.orderservice.domain.dto.order.CreateNewOrderDto;
import com.github.devtorch.saga.orderservice.domain.dto.order.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastUpdateDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "orderDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "totalAmount", expression = "java(order.getOrderItems().stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))")
    @Mapping(target = "orderStatus", expression = "java(OrderStatusEnum.CREATED)")
    @Mapping(target = "paymentStatus", expression = "java(PaymentStatusEnum.PENDING)")
    @Mapping(target = "customerId", expression = "java(new java.util.Random().nextLong(1, 101))")
    Order toOrderEntity(CreateNewOrderDto createNewOrderDto);

    OrderResponseDto toOrderResponseDto(Order order);
}
