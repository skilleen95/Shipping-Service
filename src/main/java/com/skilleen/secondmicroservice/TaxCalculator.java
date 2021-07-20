package com.skilleen.secondmicroservice;

public class TaxCalculator {

    public double addTaxToOrder(double orderPrice, double tax) {
        return orderPrice - tax;
    }

}
