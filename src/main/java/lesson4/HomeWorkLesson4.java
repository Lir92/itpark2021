package lesson4;

import java.util.Scanner;

public class HomeWorkLesson4 {
    public static void main(String[] args) {

        Scanner number = new Scanner(System.in);
        System.out.print("Введите число для вычисления квадратного корня: ");
        int request = number.nextInt();
        int startNumber = 2;

        if (request == 0) {
            System.out.println("Корень числа 0 = 0");
        } else if (request == 1){
            System.out.println("Корень числа 1 = 1");
        } else if (request > startNumber * startNumber){
            do {
                if (request == startNumber * startNumber){
                    System.out.println("Корень числа " + request + " = " + startNumber);
                }
                int increase = startNumber++;

            } while (request >= startNumber * startNumber);
        }
    }
}