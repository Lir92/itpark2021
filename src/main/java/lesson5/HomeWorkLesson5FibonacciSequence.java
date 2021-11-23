package lesson5;

import java.util.Scanner;

public class HomeWorkLesson5FibonacciSequence {
    public static void main(String[] args) {

        // Вычисление n-го числа Фибоначи - Fn = F(n-1) + F(n-2)

        Scanner requestedNumber = new Scanner(System.in);
        System.out.print("Введите цифру для вычисления числа Фибоначчи: ");

        while (!requestedNumber.hasNextInt()) {
            String text = requestedNumber.next();
            System.out.print(text + " не является числом. Введите целое число: ");
        }

        int num = requestedNumber.nextInt();

        if (num < 0) {
            System.out.println(num + " негативное число, для вычисления необходимо положительное целое число.");
            return;
        } else if (num == 0 || num == 1){
            System.out.println("1-е число Фибоначчи = 0.");
            return;
        }

        int [] fibonacciSequence = new int[num];
        fibonacciSequence[0] = 0;     // Первые 2 числа в ряде Фибоначчи
        fibonacciSequence[1] = 1;
        requestedNumber.close();

        for (int i = 2; i < num; i++) {
            fibonacciSequence[i] = (fibonacciSequence[i - 1]) + (fibonacciSequence[i - 2]);
        }

        /*
        // Вывод ряда Фибоначчи на экран
        for (int i = 0; i < num; ++i) {
            System.out.println(fibonacciSequence[i]);
        }
        */

        // в выводе ставим "-1" т.к. вызываем значение из массива.
        System.out.println(num + "-е число Фибоначчи" + " = " + fibonacciSequence[num-1]);
    }
}