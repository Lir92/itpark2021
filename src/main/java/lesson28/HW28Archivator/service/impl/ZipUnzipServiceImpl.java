package lesson28.HW28Archivator.service.impl;

import lesson28.HW28Archivator.service.ZipUnzipService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
public class ZipUnzipServiceImpl implements ZipUnzipService {

    @Override
    @SneakyThrows
    public void zipFile(Path filePath, String fileName) {

        // На вход запрашиваем у пользователя путь к файлу для архивации и имя для архива.
        try(ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(fileName)); // берём имя и создаём поток для архивирования
            FileInputStream fileInStream = new FileInputStream(String.valueOf(filePath))) { // вычитываем содержимое файла
            ZipEntry zipEntry = new ZipEntry(filePath.getFileName().toString());
            zipOutStream.putNextEntry(zipEntry);

            // переносим данные в заархивированный файл
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInStream.read(bytes)) >= 0) {
                zipOutStream.write(bytes, 0, length);
            }
        }
    }

    @Override
    @SneakyThrows
    public void unzipFile(String archivePath, String destinationPath) {

        // запрашиваем путь к файлу в виде строки
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(String.valueOf(archivePath)))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = new File (destinationPath, zipEntry.getName());

                // ниже проверяется необходимость и возможность создания новой дирректории
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Не удалось создать новую директорию: " + newFile);
                    }
                } else {
                    File parent = new File(destinationPath, zipEntry.getName()).getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Не удалось создать новую директорию: " + parent);
                    }
                }

                // после прохождения всех проверок, пишем содержимое архивного файла в разархивированный файл
                createExtractedFromZipFile(zis, newFile);
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    private void createExtractedFromZipFile(ZipInputStream zis, File newFile) throws IOException {
        byte[] buffer = new byte[1024];
        try(FileOutputStream fos = new FileOutputStream(newFile)) {
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }
}