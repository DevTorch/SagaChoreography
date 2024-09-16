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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockServiceClient stockServiceClient;
    private final OrderDtoMapper orderDtoMapper;


    @Override
    @Transactional
    public OrderResponseDto createNewOrder(CreateNewOrderDto orderRequestDto) {

        var order = orderRepository.save(orderDtoMapper.toOrderEntity(orderRequestDto));
        var items = orderRequestDto.orderItem();

        var products = items.stream().map(item -> new ProductRequestDto(
                item.stockId(),
                item.productType(),
                item.quantity()
        )).toList();

        //TODO Call StockServiceClient

        for (ProductRequestDto productRequestDto : products) {
            stockServiceClient.isProductAvailable(productRequestDto);
        }

        //TODO Если true, проверяем количество, апдейтим статус заказа, апдейтим стоки. Если false – фейлим


        return orderDtoMapper.toOrderResponseDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDto> getList() {
        return orderRepository.findAll().stream().map(orderDtoMapper::toOrderResponseDto).toList();
    }
}
