package lesson26;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

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
        return balance;
    }
}
