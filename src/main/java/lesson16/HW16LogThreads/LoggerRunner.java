package lesson16.HW16LogThreads;

import java.util.Random;

public class LoggerRunner {

    public static void main(String[] args) {
        
        new LoggerThread(" INFO", " All right, everything goes as expected").start();
        new LoggerThread(" DEBUG", " Program is working well, no problems noticed").start();

        Random random = new Random();
        boolean randomError = random.nextBoolean();
        if (!randomError) {
            new LoggerThread(" ERROR", " An ERROR occurred at ").start();
        } else {
            new LoggerThread(" WARN", " Pay attention to program execution time").start();
        }

        // new Logger().readLogFromFile(); // выводит в консоль информацию из файла, которая была до начала записи логов

    }
}