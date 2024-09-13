package com.github.devtorch.saga.orderservice.repository;

import com.github.devtorch.saga.orderservice.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
