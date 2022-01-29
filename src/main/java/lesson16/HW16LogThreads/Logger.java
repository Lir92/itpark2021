package lesson16.HW16LogThreads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger extends Thread {

    private final String filePath = "D:/log.txt";

    public String getFilePath() {
        return filePath;
    }

    public void writeLogInFile(String str) {
        try (FileWriter file = new FileWriter(filePath, true)) {
            String lineSeparator = System.getProperty("line.separator");
            file.write(str + lineSeparator);
            file.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void readLogFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) { // читаем из файла
            while(reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDateAndTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(dateTime);

    }
}

