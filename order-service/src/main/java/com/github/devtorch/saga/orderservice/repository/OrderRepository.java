package com.github.devtorch.saga.orderservice.repository;

import com.github.devtorch.saga.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
