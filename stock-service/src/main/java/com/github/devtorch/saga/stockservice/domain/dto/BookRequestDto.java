package com.github.devtorch.saga.stockservice.domain.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.Book}
 */
public record BookRequestDto(
        String title,
        String author,
        String isbn,
        @Digits(integer = 19, fraction = 2)
        BigDecimal cost,
        @Min(1) Integer quantity) {
}