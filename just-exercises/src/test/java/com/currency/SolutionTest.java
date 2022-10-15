package com.currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution target = new Solution();


    @Test
    void shouldFIndConversionWithoutDirectlyRate() {
        target.insertCurrencyRate("GBP", "EUR", new BigDecimal("10"));
        target.insertCurrencyRate("GBP", "BRL", new BigDecimal("15"));

        target.insertCurrencyRate("EUR", "USD", new BigDecimal("1.1"));

        assertEquals(new BigDecimal("110.0"), target.exchangeMoney("GBP", "USD", new BigDecimal("10")));
    }
}