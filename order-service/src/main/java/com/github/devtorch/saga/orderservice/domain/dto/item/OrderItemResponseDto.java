package com.github.devtorch.saga.orderservice.domain.dto.item;

import com.github.devtorch.saga.common.enums.ProductTypeEnum;
import com.github.devtorch.saga.orderservice.domain.Order;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link com.github.devtorch.saga.orderservice.domain.OrderItem}
 */
public record OrderItemResponseDto(
        Long id,
        UUID stockId,
        ProductTypeEnum productType,
        @Min(1) @Positive Integer quantity,
        @Digits(integer = 19, fraction = 2)
        BigDecimal cost,
        Order orderId) {
}