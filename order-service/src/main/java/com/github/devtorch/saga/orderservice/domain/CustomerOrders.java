package com.github.devtorch.saga.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class CustomerOrders {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;

//    @OneToMany(mappedBy = "customerOrders", orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

}
