package lesson21.Calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorToTest {

    private int arg1;
    private int arg2;

    public int sum() {
        return arg1+arg2;
    }

    public int division() {
        return arg1/arg2;
    }
}
