package lesson24.HW24.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    // @CsvBindByName - аннотация, устанавливающая указанные имена, как имена столбцов.
    // ВАЖНО! - имена столбцов должны меноваться также, как и в CSV файле, иначе @CsvBindByName не отработает корректно.

    @CsvBindByName(column = "Автор")
    private String author;
    @CsvBindByName(column = "Название книги")
    private String bookName;
    @CsvBindByName(column = "Издательство")
    private String publisher;
    @CsvBindByName(column = "Год издания")
    private int publishYear;
    @CsvBindByName(column = "Количество страниц")
    private int pageNumber;
    @CsvBindByName(column = "ISBN")
    private String isbn;
    @CsvBindByName(column = "Ссылка на книгу")
    private String link;
}
