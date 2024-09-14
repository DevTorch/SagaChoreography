package com.github.devtorch.saga.orderservice.service;

import com.github.devtorch.saga.orderservice.domain.dto.order.CreateNewOrderDto;
import com.github.devtorch.saga.orderservice.domain.dto.order.OrderResponseDto;

public interface OrderService {
    OrderResponseDto createNewOrder(CreateNewOrderDto orderRequestDto);
}
