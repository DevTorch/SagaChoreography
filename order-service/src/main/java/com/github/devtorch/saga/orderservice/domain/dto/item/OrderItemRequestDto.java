package com.github.devtorch.saga.orderservice.domain.dto.item;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.orderservice.domain.OrderItem}
 */
public record OrderItemRequestDto(
        String productTitle,
        @Min(1) @Positive Integer quantity,
        @Digits(integer = 10, fraction = 2)
        BigDecimal cost) {
}