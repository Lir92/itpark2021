package lesson19;

import lesson19.dto.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionRunner {

    public static void main(String[] args) throws Exception {
        Car car = new Car("Skoda", "Octavia", 1.6d/*, 1d*/);
        Class<? extends Car> aClass = car.getClass(); // 1-й способ получения ссылки на класс Class
    /**/Class<Car> carClass = Car.class; // 2-й способ получения ссылки на класс Class
        Class<?> thirdClass = Class.forName("lesson19.dto.Car"); // 3-й способ получения ссылки на класс Class. Данный метод требует обработку исключения
        Constructor<?>[] constructors = carClass.getConstructors();
        System.out.println("Конструкторы класса: " + carClass.getName() + Arrays.toString(constructors));
        System.out.println("Все методы класса: " + carClass.getName() + Arrays.toString(carClass.getDeclaredMethods()));
        System.out.println("Все публичные методы класса: " + carClass.getName() + Arrays.toString(carClass.getMethods())); // покажет все доступные классы, включая те, что унаследованы от класса-родителя
        Field[] declaredFields = carClass.getDeclaredFields();
        System.out.println("Все поля класса: " + carClass.getName() + Arrays.toString(declaredFields));
        System.out.println("Все публичные поля класса: " + carClass.getName() + Arrays.toString(carClass.getFields()));
        Car oldCar = carClass.newInstance(); // создание объекта класса

        Constructor<Car> carConstructor = getConstructor(constructors);
        Car skodaFabia = carConstructor.newInstance("Skoda", "Fabia", 1.6d, 1d);
        System.out.println(skodaFabia);

        Field modelField = declaredFields[3];
        modelField.setAccessible(true); // даёт доступ к объекту со статусом private. Изменение доступности работает
        // только пока не завершил работу вызываемый метод, повторный вызов данного метода потребует повторного указания доступности
        modelField.set(skodaFabia, 3);
        System.out.println("Изменённый авто: " + skodaFabia);

        Field declaredField = declaredFields[2];
        declaredField.setAccessible(true);
        System.out.println("Ширина авто: " + declaredField.get(skodaFabia));

        Method getMarkAndModelMethod = carClass.getDeclaredMethod("getMarkAndModel", int.class);
        getMarkAndModelMethod.setAccessible(true);
        String markAndModel = (String) getMarkAndModelMethod.invoke(skodaFabia, 1);
        System.out.println(markAndModel);

        // =====
        ClassLoader classLoader = carClass.getClassLoader();
        System.out.println(classLoader.getName());



        // =====
    }

    private static Constructor<Car> getConstructor(Constructor<?>[] constructors) {
        Constructor<Car> carConstructor = null;
        for (Constructor constructor: constructors) {
            if (constructor.getParameterTypes().length != 0) {
                carConstructor = constructor;
                break;
            }
        }
        return carConstructor;
    }
}
