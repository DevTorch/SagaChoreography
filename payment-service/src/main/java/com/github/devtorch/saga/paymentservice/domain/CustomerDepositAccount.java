package com.github.devtorch.saga.paymentservice.domain;

import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDepositAccount {

    private Long customerId;

    @Digits(integer = 19, fraction = 2)
    private BigDecimal balance;

}
