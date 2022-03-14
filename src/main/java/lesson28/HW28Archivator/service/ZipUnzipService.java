package lesson28.HW28Archivator.service;

import java.nio.file.Path;

public interface ZipUnzipService {

    void zipFile(Path filePath, String archiveName);
    void unzipFile(String archivePath, String archiveName);

}
