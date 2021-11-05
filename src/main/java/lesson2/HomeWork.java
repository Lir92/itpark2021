package lesson2;

public class HomeWork {
    // simple mathematical operations
    public static void main(String[] args) {
        System.out.println(sum(7, 10));
        System.out.println(subtract(78, 100));
        System.out.println(multiply(78, 3));
        System.out.println(divide(60, 8));
        System.out.println(cubeVolume(5, 4, 7));
        System.out.println(squareOfSum(5, 2));
        System.out.println(kineticEnergy(10, 15));
    }

    public static long sum(int num1, int num2) {
        return num1 + num2;
    }

    public static long subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static long multiply(int num1, int num2) {return num1 * num2;}

    public static long divide(int num1, int num2) {
        return num1 / num2;
    }

    public static long cubeVolume (int A, int B, int H) {
        return A*B*H;
    }

    public static long squareOfSum(int A, int B) {
        return A*A+2*A*B+B*B;
    }
    public static long kineticEnergy(int m, int V){
        return m*V*V/2;
    }
}