package com.github.devtorch.saga.orderservice.domain;

import java.math.BigDecimal;
import java.util.List;

public class Item {
    private Long id;
    private Long productStockId;
    private String productTitle;
    private Integer quantity;
    private List<Order> orders;
    private BigDecimal price;

}
