package lesson3;

import java.util.Scanner;

public class HomeWorkLesson3 {
    public static void main(String[] args) {
        // Вычисление квадратного уравнения
        double x1, x2;
        double a = 12.5;
        double b = 10;
        double c = 2;

        double discr = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Первый коэфициент не может быть равен 0");
        } else if (discr > 0) {
            x1 = (-b + Math.sqrt(discr)) / (2 * a);
            x2 = (-b - Math.sqrt(discr)) / (2 * a);
            System.out.println("Значение дискреминанта больше 0, поэтому х= " + x1 + " " + x2);
        } else if (discr == 0) {
            x1 = -b / 2 * a;
            System.out.println("Значение дискреминанта равно 0, поэтому х= " + x1);
        } else {
            System.out.println("Нет действительных решений уравнения");
        }
        System.out.println("Решение квадратного уравнения завершено");

        // Вычисление факториала числа


        /*int z = 6;
        int perm = factorial(z);
        System.out.println("Факториал числа " + z + " = " + perm);*/
        Scanner number = new Scanner(System.in);
        System.out.println("Введите число для подсчёта факториала: ");
        int requestNumber = number.nextInt();
        int perm = factorial(requestNumber);
        System.out.println("Факториал числа " + requestNumber + " = " + perm);
        number.close();
    }

    public static int factorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * factorial(f - 1);
        }
    }
}