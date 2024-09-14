package com.github.devtorch.saga.orderservice.service.impl;

import com.github.devtorch.saga.common.dto.ProductRequestDto;
import com.github.devtorch.saga.orderservice.client.StockServiceClient;
import com.github.devtorch.saga.orderservice.domain.dto.mapper.OrderDtoMapper;
import com.github.devtorch.saga.orderservice.domain.dto.order.CreateNewOrderDto;
import com.github.devtorch.saga.orderservice.domain.dto.order.OrderResponseDto;
import com.github.devtorch.saga.orderservice.repository.OrderRepository;
import com.github.devtorch.saga.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockServiceClient stockServiceClient;
    private final OrderDtoMapper orderDtoMapper;


    @Override
    public OrderResponseDto createNewOrder(CreateNewOrderDto orderRequestDto) {

        var order = orderRepository.save(orderDtoMapper.toOrderEntity(orderRequestDto));

        List<ProductRequestDto> productRequestDtos = orderRequestDto.orderItems().stream()
                .map(orderItemRequestDto -> ProductRequestDto.builder()
                        .productId(orderItemRequestDto.stockId())
                        .productType(orderItemRequestDto.productType())
                        .quantity(orderItemRequestDto.quantity())
                        .build())
                .toList();

        //TODO Call StockServiceClient

        /*for (ProductRequestDto productRequestDto : productRequestDtos) {
            if (!stockServiceClient.isProductAvailable(productRequestDto)) {
                order.getOrderItems().removeIf(orderItem -> orderItem.getStockId().equals(productRequestDto.productId()));
                throw new RuntimeException("Product not available");
            }
        }*/

        return orderDtoMapper.toOrderResponseDto(order);

    }
}
