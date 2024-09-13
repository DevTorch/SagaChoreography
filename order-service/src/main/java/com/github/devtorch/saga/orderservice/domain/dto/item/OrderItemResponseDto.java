package com.github.devtorch.saga.orderservice.domain.dto.item;

import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.orderservice.domain.OrderItem}
 */
public record OrderItemResponseDto(
        Long id,
        String productTitle,
        Integer quantity,
        @Digits(integer = 10, fraction = 2)
        BigDecimal price) {
}