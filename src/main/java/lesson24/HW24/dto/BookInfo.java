package lesson24.HW24.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookInfo {

    private String name;
    private String publisher;
    private int publishYear;
    private int pageNumber;
    private String isbn;
    private String link;


}
