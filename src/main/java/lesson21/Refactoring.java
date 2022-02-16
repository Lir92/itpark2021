package lesson21;

import java.math.BigDecimal;

public class Refactoring {

    private String name;
    private String color;
    private BigDecimal price;
    private int size;

    public Refactoring (String name, String color, BigDecimal price, int size) {
        System.out.println("text");
    }

    public String getValue() {
        return "Some text";
    }
}
