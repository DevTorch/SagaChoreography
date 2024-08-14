package com.github.devtorch.saga.stockservice.domain;

import org.apache.commons.validator.routines.ISBNValidator;

public record Isbn(String value) {
    private static final ISBNValidator VALIDATOR = new ISBNValidator();
    public Isbn  {
        if (!VALIDATOR.isValid(value)) {
            throw new IllegalArgumentException(String.format("ISBN %s is not valid", value));
        }
    }
}
