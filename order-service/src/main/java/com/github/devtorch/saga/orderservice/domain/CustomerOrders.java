package com.github.devtorch.saga.orderservice.domain;

import java.util.List;

public class CustomerOrders {

    private Long id;
    private Long customerId;
    private List<Order> orders;
}
