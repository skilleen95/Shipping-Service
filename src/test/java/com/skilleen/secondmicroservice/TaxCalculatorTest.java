package com.skilleen.secondmicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    void givenOrderPriceAndTax_addTaxToOrder_shouldSumThePriceAndTax() {
        // INPUT
        double price = 10;
        double tax = 3;

        // Execution
        double result = taxCalculator.addTaxToOrder(price, tax);

        // OUTPUT
        assertThat(result).isEqualTo(13);

    }
}
