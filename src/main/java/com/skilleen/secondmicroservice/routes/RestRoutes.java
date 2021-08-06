package com.skilleen.secondmicroservice.routes;


import com.skilleen.secondmicroservice.ShippingOrder;
import com.skilleen.secondmicroservice.ShippingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRoutes extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE)
                .route().setBody(constant("Hello World From the Shipping Service! Good to see you!"));


        rest().post("ship-order")
                .type(ShippingOrder.class)
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:ship");

        from("direct:ship")
                .log("Incoming Body is ${body}")
                .process(new ShippingProcessor());




    }
}
