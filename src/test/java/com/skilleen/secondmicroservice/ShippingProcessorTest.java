package com.skilleen.secondmicroservice;

import org.apache.camel.Exchange;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShippingProcessorTest {

    ShippingProcessor shippingProcessor = new ShippingProcessor();

    @Test
    void mockTest() {
        ShippingOrder shippingOrder = new ShippingOrder("", 0, Date.from(Instant.now()), "");
        Exchange exchange = ExchangeBuilder.anExchange(new DefaultCamelContext()).withBody(shippingOrder).build();
        // Execution
        shippingProcessor.process(exchange);

    }

}