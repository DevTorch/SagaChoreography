package com.github.devtorch.saga.stockservice.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.Book}
 */
public record BookResponseDto(
        UUID id,
        String title,
        String author,
        String isbn,
        BigDecimal cost,
        Integer quantity) {
}