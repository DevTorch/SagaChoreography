package com.github.devtorch.saga.orderservice.controller;

import com.github.devtorch.saga.orderservice.domain.dto.order.CreateNewOrderDto;
import com.github.devtorch.saga.orderservice.domain.dto.order.OrderResponseDto;
import com.github.devtorch.saga.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/place", produces = "application/json")
    public ResponseEntity<OrderResponseDto> createNewOrder(CreateNewOrderDto orderRequestDto) {
        return ResponseEntity.ok(orderService.createNewOrder(orderRequestDto));
    }


    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getList() {
        return ResponseEntity.ok(orderService.getList());
    }
}
