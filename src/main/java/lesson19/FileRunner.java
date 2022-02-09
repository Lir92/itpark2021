package lesson19;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class FileRunner {

    public static void main(String[] args) {

        String fileLocation = "D:\\test\\test.txt";
        File file = new File(fileLocation);
        /*
        .getName() - узнаём имя
        .getParent() - родительская папка файла
        .exist() - проверка на то существует ли файл: true - да, false - нет.
        .isFile() - проверка на то, является путь на файл или директорию
        .isDirectory - как и выше, проверяет является ли путь на путь директории
        .createNewFile() - создание нового пустово файла
        .mkdir() - создаёт файл с созданием директории
        .mkdirs() - создаёт файл со всеми промежуточными директориями
        .deleteOnExit() - удаление файла при завершении работы программы
        .getPath() -
        .length() - длина файла
         */
        System.out.println(file.isFile());
        System.out.println("Расширение файла: " + FileUtils.getFileExtension(file.getName()));
        System.out.println(FilenameUtils.getExtension(fileLocation)); // FilenameUtils.getExtension() - метод у Apache для получения расширения файла

    }


}
