package com.github.devtorch.saga.orderservice.domain;

import java.math.BigDecimal;

public class OrderItem {
    private Long id;
    private Long productStockId;
    private String productTitle;
    private Integer quantity;
    private BigDecimal price;

}
