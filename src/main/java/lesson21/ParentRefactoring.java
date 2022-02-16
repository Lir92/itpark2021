package lesson21;

import java.math.BigDecimal;

public class ParentRefactoring extends Refactoring{

    public ParentRefactoring(String name, String color, BigDecimal price, int size) {
        super(name, color, price, size);
    }
}
