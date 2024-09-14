package com.github.devtorch.saga.orderservice.service.impl;

import com.github.devtorch.saga.orderservice.client.StockServiceClient;
import com.github.devtorch.saga.orderservice.repository.OrderRepository;
import com.github.devtorch.saga.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockServiceClient stockServiceClient;



}
