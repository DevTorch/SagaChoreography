package com.github.devtorch.saga.orderservice.domain.dto.order;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import com.github.devtorch.saga.orderservice.domain.Order;
import com.github.devtorch.saga.orderservice.domain.dto.item.OrderItemResponseDto;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link Order}
 */
public record OrderResponseDto(
        Long id,
        Long customerId,
        List<OrderItemResponseDto> orderItems,
        @Digits(integer = 19, fraction = 2)
        BigDecimal totalAmount,
        LocalDate orderDate,
        LocalDateTime lastUpdateDate,
        OrderStatusEnum orderStatus,
        PaymentStatusEnum paymentStatus) {
}