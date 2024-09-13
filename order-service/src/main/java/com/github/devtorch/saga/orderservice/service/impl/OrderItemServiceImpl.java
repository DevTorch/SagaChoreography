package com.github.devtorch.saga.orderservice.service.impl;

import com.github.devtorch.saga.orderservice.repository.OrderItemRepository;
import com.github.devtorch.saga.orderservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
}
