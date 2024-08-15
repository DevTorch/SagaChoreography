package com.github.devtorch.saga.paymentservice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceApplicationTests.class);

    @Test
    void justPrint() {
        log.info("Testing PaymentServiceApplicationTests");
    }

}
