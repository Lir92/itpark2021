package lesson24.HW24;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lesson24.HW24.dto.Library;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CsvToList {

    @SneakyThrows
    public List<Library> getListOfBooks() {

        /*
        ниже передаём данные из CSV файла в MAP и при необходимости указываем разделитель, если в CSV файле были использованы не запятые.
        Вычитываем данные из csv-файла и собираем это всё в список "booksCollection".
        */

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CsvToList.class.getResourceAsStream("/booklist.csv")))) {
            CsvToBean<Library> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Library.class)
                    .withSeparator(';') // указываем тип разделителя, если в качестве разделителя в CSV файле использовано что-то другое кроме запятой
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().collect(Collectors.toList());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return Collections.emptyList();
    }
}
