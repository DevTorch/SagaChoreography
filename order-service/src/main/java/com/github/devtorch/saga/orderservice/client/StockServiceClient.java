package com.github.devtorch.saga.orderservice.client;

import com.github.devtorch.saga.common.dto.ProductRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class StockServiceClient {

    private final RestClient stockRestClient;

    public StockServiceClient() {
        stockRestClient = RestClient.builder()
                .baseUrl("http://localhost:8082/api/products")
                .build();
    }

    public Boolean isProductAvailable(ProductRequestDto productRequestDto) {
        return stockRestClient.post()
                .uri("/exists")
                .contentType(MediaType.APPLICATION_JSON)
                .body(productRequestDto)
                .retrieve()
                .body(Boolean.class);
    }
}
