package com.github.devtorch.saga.orderservice.domain;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private OrderId id;
    private List<OrderItem> orderItems;
    @CreationTimestamp
    private LocalDate orderDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    private OrderStatusEnum orderStatus;
    private BigDecimal totalAmount;
    private PaymentStatusEnum paymentStatus;
}
