package lesson19.dto;

import lesson19.DefaultValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor // создаёт констуркто из финальных полей (final)
@Getter
@ToString

public class Car implements Movable, IVehicle {

    private final String mark;
    private final String model;
    private final double width;
    private final double height;

    public Car() {
        this("NoName", "NoName", -1d, -1d);
    }

    @Override
    public void move() {
        System.out.printf("Находится в движении автомобиль %s %s\n", mark, model);
    }

    private String getMarkAndModel(@DefaultValue int digit) {
        return String.format("%s %s", mark, model);
    }
}
