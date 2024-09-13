package com.github.devtorch.saga.stockservice.domain.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.MobileDevice}
 */
public record MobileRequestDto(
        String brand, String model,
        String mobileOs,
        @Digits(integer = 19, fraction = 2)
        @Positive BigDecimal cost,
        @Min(1) Integer quantity) {
}