package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkLesson6 {
    public static void main(String[] args) {

        // Вычисление max, min, avg в массивах

        Scanner request = new Scanner(System.in);
        System.out.print("Введите число: ");

        while (!request.hasNextInt()) {
            String text = request.next();
            System.out.print(text + " не является числом. Введите целое число: ");
        }

        int num = request.nextInt();
        request.close();

        if (num < 0) {
            System.out.println(num + " отрицательное число, для вычисления необходимо положительное целое число.");
            return;
        } else if (num == 0){
            System.out.println("0");
            return;
        }

        double[] array = new double[num];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }

        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
        }
        max = Math.round(max * 100000.0) / 100000.0;
        System.out.println("Максимальное число в массиве " + Arrays.toString(array) + " = " + max);

        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        min = Math.round(min * 100000.0) / 100000.0;
        System.out.println("Минимальное число в массиве " + Arrays.toString(array) + " = " + min);

        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            }
        result = Math.round(result * 100000.0) / 100000.0;
        System.out.println("Среднее значение чисел в массиве " + Arrays.toString(array) + " = " + result/num);
    }
}
