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

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockServiceClient stockServiceClient;
    private final OrderDtoMapper orderDtoMapper;


    @Override
    public OrderResponseDto createNewOrder(CreateNewOrderDto orderRequestDto) {

        var order = orderRepository.save(orderDtoMapper.toOrderEntity(orderRequestDto));
        var item = orderRequestDto.orderItem();

        ProductRequestDto productRequestDto = new ProductRequestDto(
                item.stockId(),
                item.productType(),
                item.quantity()
        );

        //TODO Call StockServiceClient

        var check = stockServiceClient.isProductAvailable(productRequestDto);

        //TODO Если true, проверяем количество, апдейтим статус заказа, апдейтим стоки. Если false – фейлим


        return orderDtoMapper.toOrderResponseDto(order);

    }
}
