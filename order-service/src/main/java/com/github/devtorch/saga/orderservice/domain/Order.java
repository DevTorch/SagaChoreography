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
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private OrderId id;
    private List<CustomerOrders> customerOrders;
    @CreationTimestamp
    private LocalDate orderDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    private OrderStatusEnum orderStatus;
    private BigDecimal totalAmount;
    private PaymentStatusEnum paymentStatus;

    public Order(List<CustomerOrders> customerOrders,
                 LocalDate orderDate,
                 LocalDateTime lastUpdateDate,
                 OrderStatusEnum orderStatus,
                 BigDecimal totalAmount,
                 PaymentStatusEnum paymentStatus) {
        this.id = new OrderId();
        this.customerOrders = customerOrders;
        this.orderDate = orderDate;
        this.lastUpdateDate = lastUpdateDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate);
    }
}
