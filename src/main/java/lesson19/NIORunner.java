package lesson19;

import java.io.BufferedReader;
import java.nio.file.*;
import java.util.stream.Collectors;

public class NIORunner {

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("D:\\test",".", "test.txt");
        System.out.println("Путь до файла: " + filePath);
        System.out.println("-------------------------");
        System.out.println("Имя файла - " + filePath.getFileName().toFile());
        System.out.println("-------------------------");
        System.out.println("Путь до файла - " + filePath.normalize());
        System.out.println("-------------------------");

        Files.copy(filePath, System.out);
        System.out.println("-------------------------");
        System.out.println(Files.lines(filePath).collect(Collectors.joining(",")));
        try(BufferedReader reader = Files.newBufferedReader(filePath)){

        }
    }
}
