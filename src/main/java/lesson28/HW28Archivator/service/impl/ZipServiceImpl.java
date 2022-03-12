package lesson28.HW28Archivator.service.impl;

import lesson28.HW28Archivator.service.ZipService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ZipServiceImpl implements ZipService {

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
}