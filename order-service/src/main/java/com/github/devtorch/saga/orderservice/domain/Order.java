package com.github.devtorch.saga.orderservice.domain;

import com.github.devtorch.saga.common.enums.OrderStatusEnum;
import com.github.devtorch.saga.common.enums.PaymentStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @EmbeddedId
    private OrderId id;

    @Column(name = "customer_id")
    @ManyToMany
    @JoinTable(name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "orderItem_id"))
    private Set<OrderItem> orderItemId = new LinkedHashSet<>();

    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalAmount;

    @CreationTimestamp
    private LocalDate orderDate;

    @Version
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Enumerated(value = EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    public Order(
            Set<OrderItem> orderItemId,
            BigDecimal totalAmount,
            LocalDate orderDate,
            LocalDateTime lastUpdateDate,
            OrderStatusEnum orderStatus,
            PaymentStatusEnum paymentStatus) {

        Assert.notNull(orderItemId, "orderItemId must not be null");
        this.orderItemId = orderItemId;
        Assert.notNull(totalAmount, "totalAmount must not be null");
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.lastUpdateDate = lastUpdateDate;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Order order = (Order) o;
        return getId() != null && Objects.equals(getId(), order.getId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }
}
