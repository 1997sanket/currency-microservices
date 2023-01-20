package com.kamble.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(from, to);

        if(currencyConversion != null) {
            return CurrencyConversion.builder()
                    .id(currencyConversion.getId())
                    .from(from)
                    .to(to)
                    .quantity(quantity)
                    .conversionMultiple(currencyConversion.getConversionMultiple())
                    .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                    .environment("currency-exchange port: " + currencyConversion.getEnvironment())
                    .build();
        }

        throw new RuntimeException("Could not exchange currency");
    }
}
