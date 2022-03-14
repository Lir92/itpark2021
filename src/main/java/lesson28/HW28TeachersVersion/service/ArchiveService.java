package lesson28.HW28TeachersVersion.service;

import net.lingala.zip4j.exception.ZipException;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface ArchiveService {

    // метод возвращает ссылку на архив, который будет получаться
    Optional<String> zip(String source);

    // аннотация @Nullable даёт возможность определять, что какой-то из параметров может быть null - т.е. не указан
    Optional<String> unzip(String source, @Nullable String password);
}