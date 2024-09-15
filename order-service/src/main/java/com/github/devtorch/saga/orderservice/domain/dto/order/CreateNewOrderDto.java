package com.github.devtorch.saga.orderservice.domain.dto.order;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import com.github.devtorch.saga.orderservice.domain.dto.item.OrderItemRequestDto;

/**
 * DTO for {@link com.github.devtorch.saga.orderservice.domain.Order}
 */
public record CreateNewOrderDto(
        OrderItemRequestDto orderItem,
        OrderStatusEnum orderStatus,
        PaymentStatusEnum paymentStatus) {
}