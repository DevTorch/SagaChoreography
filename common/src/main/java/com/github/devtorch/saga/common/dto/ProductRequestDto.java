package com.github.devtorch.saga.common.dto;

import com.github.devtorch.saga.common.enums.ProductTypeEnum;

import java.util.UUID;

public record ProductRequestDto(
        UUID productId,
        ProductTypeEnum productType,
        Integer quantity) {
}
