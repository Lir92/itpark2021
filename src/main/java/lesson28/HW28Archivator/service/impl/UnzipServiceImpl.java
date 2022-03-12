package lesson28.HW28Archivator.service.impl;

import lesson28.HW28Archivator.service.UnzipService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class UnzipServiceImpl implements UnzipService {

    @Override
    @SneakyThrows
    public void unzipFile(String archivePath, String destinationPath) {

        byte[] buffer = new byte[1024];

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
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }
}