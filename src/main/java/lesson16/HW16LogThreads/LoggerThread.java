package lesson16.HW16LogThreads;

import java.util.Random;


public class LoggerThread extends Thread {

    private final String loggerName;
    private final String loggerMessage;
    Logger logger = new Logger();

    public LoggerThread (String loggerName, String loggerMessage) {
        this.loggerName = loggerName;
        this.loggerMessage = loggerMessage;

    }

    public String getLoggerName() {
        return loggerName;
    }

    public String getLoggerMessage() {
        return loggerMessage;
    }

    public static void print (Object ob) {
        System.out.println(ob);
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + 60 * 1000; // устанавливаем время завершения программы
        do {
            print(logger.getDateAndTime() + " " + Thread.currentThread().getState() + " " + getLoggerName() + " " + getLoggerMessage()); // данный код можно использовать для проверки работы записи в файл
            logger.writeLogInFile(logger.getDateAndTime() + " " + Thread.currentThread().getState() + " " + getLoggerName() + " " + getLoggerMessage());
            try {
                Thread.sleep(new Random().nextInt(5001)); // new Random().nextInt(5001) - генерация случайного числа до определённой границы
            } catch (InterruptedException io) {
                Thread.currentThread().interrupt();
                io.printStackTrace();
            }
        } while(System.currentTimeMillis() < end);
        logger.readLogFromFile(); // выводит логи сразу после окончания записи
    }
}