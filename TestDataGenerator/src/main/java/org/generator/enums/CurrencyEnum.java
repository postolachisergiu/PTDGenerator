package org.generator.enums;

import org.generator.random.RandomEnumGenerator;

public enum CurrencyEnum {
    EUR, GBP, USD;

    public static String generateCurrency() {
        RandomEnumGenerator reg = new RandomEnumGenerator(CurrencyEnum.class);
        CurrencyEnum currency = (CurrencyEnum) reg.randomEnum();
        return currency.toString();
    }
}

