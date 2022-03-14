package lesson28.HW28TeachersVersion;

import lesson28.HW28TeachersVersion.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class ZipRunner {

    // !! NB: При выполнении этого ДЗ в настройках конфигурации SpringBoot указывался путь к файлу/ папке, которые
    // архивировались. Путь указывался в Modify options -> Program Arguments.

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите параметры запуска программы и перезапустите её.");
            return;
        }
        System.out.println("Архиватор начал работу");
        ConfigurableApplicationContext appContext = SpringApplication.run(ZipRunner.class, args);
        ArchiveService archiveService = appContext.getBean(ArchiveService.class);

        Arrays.stream(args).findFirst().ifPresentOrElse(
                file -> {
                    String zip = archiveService.zip(file).orElseThrow(() -> new IllegalStateException("Невозможно выполнить архивацию"));
                    System.out.printf("Архиватор успешно завершил свою работу. Результат %s", zip);
                },
                () -> {
                    System.out.println("Необходимо указать архивируемый файл в качестве параметра");
                    System.exit(0);
                }
        );
    }
}