package lesson28.HW28TeachersVersion.service.impl;

import lesson28.HW28TeachersVersion.service.ArchiveService;
import lombok.SneakyThrows;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final String ZIP = ".zip";

    @Override
    public Optional<String> zip(String source) {
        // При помощи FilenameUtils.removeExtension мы получаем имя файла без расширения и присваиваем ему расширение "zip".
        // Затем создаём новый файл-архив с именем, которое получили до этого. Также для того, чтобы файл сохранялся в томже месте
        // мы запрашиваем родительский файл при помощи file.getParent()
        // В конце добавляем файл, который приходит на вход в новый архивный-файл.
        File file = new File(source);
        String newZipFileName = FilenameUtils.removeExtension(source) + ZIP;
        try(ZipFile zipFile = new ZipFile(file.getParent() + File.separator + FilenameUtils.getName(newZipFileName))){
            // делаем проверку является ли поступаемый файл файлом, или директорией
            if (file.isFile()) {
                zipFile.addFile(source);
            } else {
                zipFile.addFolder(file);
            }
        // при возникновении проблем с созданием архива возвращается пустой Optional
        }catch (IOException io) {
            System.out.printf("Возникли проблемы во время архивирования файла с указанием ссылки на него %s", source);
            return Optional.empty();
        }
        return Optional.of(newZipFileName);
    }

    @Override
    public Optional<String> unzip(String source, String password) {
        ZipFile zipFile = new ZipFile(source);

        // задаём пароль. !!!NB: пароли всегда указываются как char, а не String.
        if (StringUtils.isNotBlank(password)) {
            zipFile.setPassword(password.toCharArray());
        }
        // разархивируем файл
        String parent = new File(source).getParent(); // получаем расположение архива, чтобы туда вытащить данные из архива.
        try {
            zipFile.extractAll(parent);

        } catch (ZipException ze) {
            System.out.printf("Возникли проблемы во время разархивирования файла с указанием ссылки на него %s", source);
        }
        return Optional.of(parent);
    }
}