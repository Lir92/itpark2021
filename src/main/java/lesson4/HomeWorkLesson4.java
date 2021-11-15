package lesson4;

import java.util.Scanner;

public class HomeWorkLesson4 {
    public static void main(String[] args) {

        Scanner number = new Scanner(System.in);
        System.out.print("Введите число для вычисления квадратного корня: ");
        while (!number.hasNextInt()){
            String text = number.next();
            System.out.print( text + " не является целым числом. Введите число для вычисления квадратного корня: ");
        }
        int request = number.nextInt();
        int startNumber = 2;

        if (request == 0) {
            System.out.println("Корень числа 0 = 0");
        } else if (request == 1){
            System.out.println("Корень числа 1 = 1");
        } else if (request < 0){
            System.out.println("Отрицательные числа не имеют квадратных корней");
        } else if (request > startNumber * startNumber){
            do {
                if (request == startNumber * startNumber){
                    System.out.println("Корень числа " + request + " = " + startNumber);
                    break;
                }
                startNumber++;
                if ( request < startNumber * startNumber){
                    System.out.println("Число " + request + " не имеет квадратного корня");
                }
            } while (request >= startNumber * startNumber);
        }
    }
}