package com.github.devtorch.saga.orderservice.repository;

import com.github.devtorch.saga.orderservice.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
