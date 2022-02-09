package lesson18;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputStreamRunner {
@SneakyThrows({IOException.class})
    public static void main(String[] args) {
    /*
    при использовании try-catch блока можно обойти необходимость писать закрывающие блоки для потоков.
     */
        try(InputStream fileInputStream = InputStreamRunner.class.getResourceAsStream("/file.txt")) {
            byte[] bytes = fileInputStream.readAllBytes();
        /*
        .read() - проверяет возможность прочитать файла: если значение 1 - данные есть, -1 - нет данных.
        .readAllBytes() - читает всё, что есть в файле
        .skip(long n) - возможность пропускать какое-то количество байт и не читать
        .available() - проверка наличия количества данных для чтения
        .transferTo(OutputStream out) - перенос содержимого имеющегося InputStream в другой OutputStream

        */
            System.out.println(new String(bytes));
        }
    //fileInputStream.close();

    System.out.println("------------ 1 --------------");

    // ниже мы перепысываем данные из файла "file.txt" в новый файл, который находится на диске "D:\\test\\test.txt"
    try(InputStream inputStream = InputStreamRunner.class.getResourceAsStream("/file.txt");
    FileOutputStream out = new FileOutputStream("D:\\test\\test.txt")) {// что бы файл создался и произошла запись,
        // необходимо в указанном месте создать папку, которую прописываем. Java сама не создаёт папки, только файлы.
        inputStream.transferTo(out);
    }

    char[] buffer = new char[8]; // здесь выделяем кол-во памяти для чтения (тут 512 байт). При выделении памяти большей, чем
    // есть в файле данных, оставшаяся память займётся нечитаемыми символами
    try(FileReader fileReader = new FileReader("D:\\test\\test.txt")) {
        String result = "";
        while ((fileReader.read(buffer)) != -1) {
            result += new String(buffer);
        }
        System.out.println("Чтение файла завершено. Его содержимое: " + "\n" + result);
    }
//    out.close();
//    inputStream.close();

    System.out.println("------------ 2 --------------");

    try(BufferedReader br = new BufferedReader(
            new InputStreamReader(InputStreamRunner.class.getResourceAsStream("/file.txt")/*,
                    StandardCharsets.ISO_8859_1.name()*/))) {
        //System.out.println(br.lines().collect(Collectors.joining()));
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        while (br.read() != -1) {
            System.out.println(br.readLine()); // чтение по строкам
        }
    }

    System.out.println("Запись в файл произведена успешно");

    System.out.println("------------ 3 --------------");

    try(BufferedReader br = new BufferedReader(
            new InputStreamReader(InputStreamRunner.class.getResourceAsStream("/file.txt")))) {
        while (br.read() != -1) {
            System.out.println(br.readLine()); // чтение по строкам
        }
    }

    BufferedReader br = new BufferedReader(new FileReader("D:\\test\\test.txt"));
    String str = null;
    StringBuilder sb = new StringBuilder();
    while ((str = br.readLine()) != null) {
        String[] arrayWords = str.split("\\s+");
        for (String s : arrayWords) {
            sb.append(s + "\n");
        }
    }
    System.out.println(sb);


    }
}