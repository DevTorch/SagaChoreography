package com.github.devtorch.saga.stockservice.domain.dto;

import com.github.devtorch.saga.stockservice.domain.BookId;

import java.math.BigDecimal;

/**
 * DTO for {@link com.github.devtorch.saga.stockservice.domain.Book}
 */
public record BookResponseDto(
        BookId id,
        String title,
        String author,
        String isbn,
        BigDecimal cost,
        Integer quantity) {
}