package lesson28.HW28Archivator.service;

import java.nio.file.Path;

public interface ZipService {

    void zipFile(Path filePath, String archiveName);

}
