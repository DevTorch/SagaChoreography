package com.github.devtorch.saga.orderservice.domain;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @EmbeddedId
    private OrderId id;

    @ManyToMany
    @JoinTable(name = "orders_orderItems",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "orderItems_id"))
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    @CreationTimestamp
    private LocalDate orderDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
    private OrderStatusEnum orderStatus;
    private BigDecimal totalAmount;
    private PaymentStatusEnum paymentStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_orders_id")
    private CustomerOrders customerOrders;

}
