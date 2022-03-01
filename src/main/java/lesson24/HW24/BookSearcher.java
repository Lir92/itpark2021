package lesson24.HW24;

import lesson24.HW24.dbLibrary.LibraryToDbTable;
import lesson24.HW24.dto.Library;

import java.util.List;
import java.util.Scanner;

public class BookSearcher {

    public static void main(String[] args) {
        System.out.print("Введите имя автора или название книги:");
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        final List<Library> result = LibraryToDbTable.searchBook(request);
        if (result.isEmpty()) {
            System.out.println("Книга по заданным вами параметрам не нашлась");
        }
        System.out.println(result);
    }
}
