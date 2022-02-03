package lesson18.HW18TextFromFileToFiles;

import lombok.SneakyThrows;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WriteTextFromFileToFiles {

    @SneakyThrows
    public static void main(String[] args) {

        String fileToRead = "/file.txt";
        String filePath = "D:\\test\\.txt";

        new Thread(() -> WriteTextFromFileToFiles.
                writeToFile(WriteTextFromFileToFiles.class.getResourceAsStream(fileToRead), filePath)).start();
    }

    @SneakyThrows
    public static void writeToFile(InputStream is, String readyFile) {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(is))) {
            String[] pathForNewFiles = readyFile.split("\\."); // здесь помещаем название файла в массив и разделяем его "." точкой
            // на 2 части: [0] - тест до разделителя, [1] - текст после разделителя. Таким образом мы получаем возможность создавать номерные файлы

            int counter = 1;
            while (br.ready()) {
                String heading = Arrays.toString(fileName());
                FileWriter fileWriter = new FileWriter(pathForNewFiles[0] + " " + heading + " " + counter + "." + pathForNewFiles[1]); // тут создаём новый файл с новым номером, н-р "Новая папка 1"
                fileWriter.write(br.readLine());
                fileWriter.close();
                counter ++;
            }
        }
    }

    @SneakyThrows
    public static String[] fileName() {
        String path = "D:\\test\\test.txt";
        StringBuilder sb = new StringBuilder();
        try (Scanner scan = new Scanner(new File(path))) {
            sb.append(scan.nextLine());
            scan.useDelimiter("!");
        }
//        String[] array = sb.toString().split("\n"); // тоже, что и ниже
//        return array;

        return sb.toString().split("\n");
    }
}