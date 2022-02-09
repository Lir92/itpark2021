package lesson19.HW19BankAccoutOperations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor // создаёт констуркто из финальных полей (final)
@Getter
@ToString

public class Account {

    private final BigDecimal balance = BigDecimal.ZERO;
    

}
