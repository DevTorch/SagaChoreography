package com.github.devtorch.saga.stockservice.domain.dto;

import com.github.devtorch.saga.stockservice.domain.MobileDeviceId;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.MobileDevice}
 */
public record MobileResponseDto(
        MobileDeviceId id,
        String brand,
        String model,
        String mobileOs,
        @Digits(integer = 19, fraction = 2)
        BigDecimal cost,
        Integer quantity) {
}