package com.github.devtorch.saga.orderservice.domain.dto.order;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import com.github.devtorch.saga.orderservice.domain.dto.item.OrderItemRequestDto;

import java.util.List;

/**
 * DTO for {@link com.github.devtorch.saga.orderservice.domain.Order}
 */
public record CreateNewOrderDto(
        List<OrderItemRequestDto> orderItems,
        OrderStatusEnum orderStatus,
        PaymentStatusEnum paymentStatus) {
}