package lesson2;

public class Calculations {
    public static void main(String[] args) {
        System.out.println("My first code at the lesson");
        long sum = calculate(3, 5);
        System.out.println(sum);
        long sum1 = calculate(5, 10);
        System.out.println(sum1);
        long subtraction = minus(2, 18);
        System.out.println(subtraction);
        long number = multiply(5);
        System.out.print(number);
    }

    private static long calculate(int arg1, int arg2) {
        return arg1 + arg2;
    }

    private static long minus(int arg1, int arg2) {
        return arg1 - arg2;
    }

    private static long multiply (int arg1) {
        return 3 * arg1 + 15;
    }
}
