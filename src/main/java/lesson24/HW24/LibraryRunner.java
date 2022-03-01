package lesson24.HW24;

import lesson24.HW24.dbLibrary.LibraryToDbTable;
import lesson24.HW24.dto.AuthorInfo;
import lesson24.HW24.dto.BookInfo;
import org.apache.commons.lang3.tuple.Pair;

public class LibraryRunner {

    public static void main(String[] args) {
        LibraryToDbTable.deleteTableIfExists();
        LibraryToDbTable.createTables();

        // наполняем таблицы из CSV-файла.
        CsvToList.getListOfBooks().stream().map(library -> Pair.of(
                new AuthorInfo(library.getAuthor()),
                new BookInfo(library.getBookName(),
                        library.getPublisher(),
                        library.getPublishYear(),
                        library.getPageNumber(),
                        library.getIsbn(),
                        library.getLink()))).forEach(pair ->
                            LibraryToDbTable.insertAuthorsToTable(pair.getLeft()).ifPresent(authorID ->
                                LibraryToDbTable.insertBooksToTable(authorID, pair.getRight())));
    }
}
