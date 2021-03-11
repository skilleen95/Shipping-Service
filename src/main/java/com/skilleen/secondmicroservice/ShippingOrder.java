package com.skilleen.secondmicroservice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ShippingOrder {

    private String name;
    private double price;
    private Date dateShipped;
    private String shippingFromLocation;

    public ShippingOrder(String name, double price) {
        this.name = name;
        this.price = price;
        this.dateShipped = new Date();
        this.shippingFromLocation = "";

    }
}
