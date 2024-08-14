package com.github.devtorch.saga.stockservice.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID id) {

    public BookId {
        Assert.notNull(id, "ID cannot be null");
        Assert.isTrue(!id.toString().isEmpty(), "ID cannot be empty");
    }

    public BookId() {
        this(UUID.randomUUID());
    }
}
