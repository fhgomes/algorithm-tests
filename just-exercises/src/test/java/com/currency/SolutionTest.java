package com.currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* We are a currency exchange that maintains the current exchange rates between currencies.

    A user can come to us with some amount in one currency and request the equivalent amount in a different currency.
    Given a list of exchange rates between currencies, write a function that calculates currency rate between any 2 currencies.

    // Example 1 -
    // (GBP, EUR, 10)     - read as "1 GBP equals 10 EUR"
    // (EUR, USD, 1.1)    - "1 EUR equals 1.1 USD"

    // (10 GBP, USD) => ? - "10 GBP equals how many USD?"

// Answer: 110
// Explanation: 10 GBP = 10 x (10 EUR) = 10 x (10 x (1.1 USD)) = 110 USD
*/
class SolutionTest {

    public static final String GBP = "GBP";
    public static final String EUR = "EUR";
    public static final String BRL = "BRL";
    public static final String USD = "USD";
    public static final String RUB = "RUB";
    public static final String YEN = "YEN";
    Solution target = new Solution();


    @Test
    @DisplayName("Should convert from GBP to USD using indirectly rate EUR an result 110.0")
    void shouldFIndConversionWithoutDirectlyRate() {
        target.insertCurrencyRate(GBP, EUR, new BigDecimal("10"));
        target.insertCurrencyRate(GBP, BRL, new BigDecimal("15"));

        target.insertCurrencyRate(EUR, USD, new BigDecimal("1.1"));
        target.insertCurrencyRate(BRL, USD, new BigDecimal("1.1"));

        assertEquals(new BigDecimal("110.0"), target.exchangeMoney(GBP, USD, new BigDecimal("10")));
    }

    @Test
    @DisplayName("Should convert from GBP to USD using indirectly rates BRL, EUR")
    void shouldFIndConversionWithoutDirectlyRate2Level() {
        target.insertCurrencyRate(GBP, BRL, new BigDecimal("15"));
        target.insertCurrencyRate(GBP, RUB, new BigDecimal("13"));

        target.insertCurrencyRate(EUR, USD, new BigDecimal("1.1"));
        target.insertCurrencyRate(EUR, YEN, new BigDecimal("1.2"));
        target.insertCurrencyRate(BRL, EUR, new BigDecimal("2"));

        assertEquals(new BigDecimal("330.0"), target.exchangeMoney(GBP, USD, new BigDecimal("10")));
    }
}