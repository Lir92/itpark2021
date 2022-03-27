package lesson33.HW33CurrencyConverter.service;

import java.math.BigDecimal;

public interface CurrencyConverterService {

    String getCurrencyName(String name);
    BigDecimal convertCurrency(String name, int qtty);
}
