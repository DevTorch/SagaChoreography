package com.github.devtorch.saga.orderservice.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record OrderId(UUID id) {
    public OrderId {
        Assert.notNull(id, "ID cannot be null");
        Assert.isTrue(!id.toString().isEmpty(), "ID cannot be empty");
    }

    public OrderId() {
        this(UUID.randomUUID());
    }
}
