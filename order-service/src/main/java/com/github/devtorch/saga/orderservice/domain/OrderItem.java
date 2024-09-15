package com.github.devtorch.saga.orderservice.domain;

import com.github.devtorch.saga.common.enums.ProductTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID stockId;

    @Enumerated(value = EnumType.STRING)
    private ProductTypeEnum productType;

    private Integer quantity;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

}
