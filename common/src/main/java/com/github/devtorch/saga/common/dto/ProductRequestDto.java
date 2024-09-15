package com.github.devtorch.saga.common.dto;

import com.github.devtorch.saga.common.enums.ProductTypeEnum;
import lombok.Builder;

import java.util.UUID;
@Builder
public record ProductRequestDto(
        UUID productId,
        ProductTypeEnum productType,
        Integer quantity) {
}
