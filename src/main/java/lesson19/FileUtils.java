package lesson19;

import lombok.experimental.UtilityClass;

import java.util.Objects;

// код ниже выдаёт нам расширение файла

@UtilityClass
public class FileUtils {

    public String getFileExtension(String fileName) {
        if (!Objects.isNull(fileName) && !fileName.isEmpty()) {
            int dotIndex = fileName.lastIndexOf(".");
            return dotIndex < fileName.length() ? fileName.substring(dotIndex + 1) : null;
        }
        return null;
    }
}
