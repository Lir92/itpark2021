package lesson26.impl;

import lesson26.AccountService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Primary // при наличии нескольких одинаковых бинов, данная аннотация определяет, какие бины должны быть взяты.
public class AnotherAccountService implements AccountService {

    private BigDecimal balance;

    @Override
    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
    }

    @Override
    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }

    @Override
    public BigDecimal getCurrentBalance() {
        return null;
    }
}
