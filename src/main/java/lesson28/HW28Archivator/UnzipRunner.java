package lesson28.HW28Archivator;

import lesson28.HW28Archivator.service.ZipUnzipService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class UnzipRunner {

    public static void main(String[] args) {

        final ConfigurableApplicationContext appContext = SpringApplication.run(UnzipRunner.class, args);
        final ZipUnzipService dearchivator = appContext.getBean(ZipUnzipService.class);

        boolean isErrorHappened = false;

        do {
            System.out.print("Укажите путь до файла, который необходимо разархивировать: ");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt()) {
                String txt = scanner.next();
                System.out.println(txt + " не ялвляется путём до файла, попробуйте ещё раз");
            }
            String pathToZip = scanner.next();

            System.out.print("Укажите путь куда необходимо разархивировать: ");
            scanner = new Scanner(System.in);
            while (scanner.hasNextInt()) {
                String txt = scanner.next();
                System.out.println(txt + " не ялвляется путём до файла, попробуйте ещё раз");
            }
            String pathToFile = scanner.next();

            try {
                dearchivator.unzipFile(pathToZip, pathToFile);
                isErrorHappened = false;
            } catch (Exception ioe) {
                System.out.println("Не удалось разархивировать файл. Проверьте правильно ли указаны пути и находится ли архив в папке.");
                ioe.printStackTrace();
                isErrorHappened = true;
            }
        } while (isErrorHappened);
    }
}
