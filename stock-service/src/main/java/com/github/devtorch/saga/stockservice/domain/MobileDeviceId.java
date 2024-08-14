package com.github.devtorch.saga.stockservice.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record MobileDeviceId(UUID id) {

    public MobileDeviceId {
        Assert.notNull(id, "ID cannot be null");
        Assert.isTrue(!id.toString().isEmpty(), "ID cannot be empty");
    }

    public MobileDeviceId() {
        this(UUID.randomUUID());
    }
}
