package com.github.devtorch.saga.stockservice.domain.dto;

import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.MobileDevice}
 */
public record MobileResponseDto(
        UUID id,
        String brand,
        String model,
        String mobileOs,
        @Digits(integer = 19, fraction = 2)
        BigDecimal cost,
        Integer quantity) {
}