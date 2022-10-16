package com.currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

// Main class should be named 'Solution'
class Solution {
    Map<String, List<CurrencyRate>> originCurrenciesRate = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello, World");
    }

    public BigDecimal exchangeMoney(String fromCurrency, String toCurrency, BigDecimal originalValue) {
        if (!originCurrenciesRate.containsKey(fromCurrency)) {
            throw new RuntimeException("don have GBP changes");
        }

        List<CurrencyRate> knownRatesFromOrigin = originCurrenciesRate.get(fromCurrency);
        Optional<CurrencyRate> currencyWithTarget = knownRatesFromOrigin
                .stream()
                .filter(currRate -> toCurrency.equals(currRate.getTargetCurrency())).findAny();

        if (currencyWithTarget.isPresent()) {
            return originalValue.multiply(currencyWithTarget.get().getRate());
        }

        for (CurrencyRate otherCurrencyRate: knownRatesFromOrigin) {
            if (originCurrenciesRate.containsKey(otherCurrencyRate.getTargetCurrency())) {
                List<CurrencyRate> knownRatesFromOriginToOtherCurrency = originCurrenciesRate.get(otherCurrencyRate.getTargetCurrency());

                Optional<CurrencyRate> currencyIntermediate = knownRatesFromOriginToOtherCurrency
                        .stream()
                        .filter(currRate -> toCurrency.equals(currRate.getTargetCurrency())).findAny();

                if (currencyIntermediate.isPresent()) {
                    //10 x 10 = 100
                    BigDecimal intermediateValue = originalValue.multiply(otherCurrencyRate.getRate());

                    //100 x 1.1
                    return intermediateValue.multiply(currencyIntermediate.get().getRate());
                }
            }
        }

        return BigDecimal.ZERO;
    }

    public void insertCurrencyRate(String fromCurrency, String toCurrency, BigDecimal rate) {
        CurrencyRate newCurrencyRate = new CurrencyRate(fromCurrency, toCurrency, rate);
        if (originCurrenciesRate.containsKey(fromCurrency)) {
            originCurrenciesRate.get(fromCurrency).add(newCurrencyRate);

            return;
        }
        List<CurrencyRate> objects = new ArrayList<>();
        objects.add(newCurrencyRate);
        originCurrenciesRate.put(fromCurrency, objects);
    }

    class CurrencyRate {
        private String originCurrency;
        private String targetCurrency;
        private BigDecimal rate;

        public CurrencyRate(String originCurrency, String targetCurrency, BigDecimal rate) {
            this.originCurrency = originCurrency;
            this.targetCurrency = targetCurrency;
            this.rate = rate;
        }

        public String getOriginCurrency() {
            return originCurrency;
        }

        public String getTargetCurrency() {
            return this.targetCurrency;
        }

        public BigDecimal getRate() {
            return this.rate;
        }
    }

}
