package com.skilleen.secondmicroservice;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

public class ShippingProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        ShippingOrder order = exchange.getIn().getBody(ShippingOrder.class);
        order.getDateShipped().setTime(order.getDateShipped().getTime() + TimeUnit.DAYS.toMillis(3));
        order.setShippingFromLocation(City.randomCity().toString());

        exchange.getOut().setBody(createReturnMessage(order));
    }

    private String createReturnMessage(ShippingOrder order) {
        return "Order will be shipped from " + order.getShippingFromLocation() + " on " + order.getDateShipped();
    }

}
