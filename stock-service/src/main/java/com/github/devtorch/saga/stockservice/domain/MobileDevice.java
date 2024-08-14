package com.github.devtorch.saga.stockservice.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MobileDevice {
    @EmbeddedId
    private MobileDeviceId id;
    private String brand;
    private String model;
    private String mobileOs;
    private BigDecimal cost;

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
