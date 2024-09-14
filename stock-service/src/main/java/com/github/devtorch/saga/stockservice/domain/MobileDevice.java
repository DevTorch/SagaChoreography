package com.github.devtorch.saga.stockservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MobileDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brand;
    private String model;
    private String mobileOs;
    @Digits(integer = 19, fraction = 2)
    private BigDecimal cost;
    @Min(1)
    private Integer quantity;

    public MobileDevice(String brand, String model, String mobileOs, BigDecimal cost) {
        Assert.notNull(brand, "brand must not be null");
        this.brand = brand;
        Assert.notNull(model, "model must not be null");
        this.model = model;
        Assert.notNull(mobileOs, "mobileOs must not be null");
        this.mobileOs = mobileOs;
        Assert.notNull(cost, "cost must not be null");
        this.cost = cost;
    }
}
