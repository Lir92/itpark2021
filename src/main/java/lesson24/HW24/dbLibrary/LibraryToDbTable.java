package lesson24.HW24.dbLibrary;

import lesson24.DbRunner;
import lesson24.HW24.dto.AuthorInfo;
import lesson24.HW24.dto.BookInfo;
import lesson24.HW24.dto.Library;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.*;
import java.util.*;

@UtilityClass
public class LibraryToDbTable {

    /*
    ниже создаём таблицы в БД с данными, которые получили в BooksToList
     */

    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(DbRunner.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ниже метод для установки соединения с БД
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
    }

    // проверяем существует ли такая таблица в БД и удаляем её, если она уже есть.
    public void deleteTableIfExists() {
        try(final Connection connection = getConnection();
            PreparedStatement deleteBookTable = connection.prepareStatement("drop table if exists book");
            PreparedStatement deleteAuthorTable = connection.prepareStatement("drop table if exists author")) {
            deleteBookTable.execute();
            deleteAuthorTable.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void createTables() {
        try (final Connection connection = getConnection();
             final PreparedStatement createAuthorTable = connection.prepareStatement(
                     """
                            create table author
                            (
                                id int auto_increment,
                                auth_name varchar(255) not null unique,
                                constraint author_pk
                                    primary key (id)
                            );
                            """
            );
             final PreparedStatement createBookTable = connection.prepareStatement(
                        """
                            create table book
                            (
                                id int auto_increment,
                                book_name varchar(300)  not null,
                                publisher varchar(100)  null,
                                year_of_publishing int not null,
                                page_number int not null,
                                isbn varchar(20) not null unique ,
                                link varchar(1000) null,
                                auth_id int null,
                                constraint book_pk
                                    primary key (id),
                                constraint book_auth_fk
                                    foreign key (auth_id) references author (id)
                            );
                            """)
        ) {
            createAuthorTable.execute();
            createBookTable.execute();
    } catch (SQLException se) {
            System.out.println("Такая таблица уже существует");
        }
    }

    /*
    Ниже 2 метода для добавления информации авторов и книг в таблицы.
    В insertAuthorsToTable на вход просим передать getName() из AuthorInfo.
    Используем тип Optional<Integer> для того, чтобы в LibraryRunner иметь возможность делать проверку ifPresent для ID
    при объединении таблиц.
    -
    В insertBooksToTable необходимо передать ID из таблицы авторов и информацию из BookInfo.
    -
    Не забываем выполнять команду .execute() при указании стейтментов БД для их выполнения.
    =
    ВАЖНО! При указании столбца, куда будут добавляться данные, писать тоже имя, что указано в БД
    =
     */
    public Optional<Integer> insertAuthorsToTable(AuthorInfo auth) {
        try(final Connection connection = getConnection();
            PreparedStatement authorStatement = connection.prepareStatement("insert into author(auth_name) values(?)");
            PreparedStatement searchAuthorStatement = connection.prepareStatement("select id from author where auth_name = ?")) {
            authorStatement.setString(1, auth.getName());
            authorStatement.execute();
            searchAuthorStatement.setString(1, auth.getName());
            final ResultSet resultSet = searchAuthorStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(resultSet.getInt("id"));
            }
        }catch (SQLException se) {
            System.out.println("При добавлении авторов соединение не установлено");
            se.printStackTrace();

        }
        return Optional.empty(); // если возникнет ошибка, вернётся пустой список.
    }

    public void insertBooksToTable(int authorId, BookInfo book) {
        try(final Connection connection = getConnection();
            final PreparedStatement bookStatement = connection.prepareStatement(
                    """
                            insert into book(book_name, publisher, year_of_publishing, page_number, isbn, link, auth_id)
                            values (?, ?, ?, ?, ?, ?, ?)
                        """
            )) {
            bookStatement.setString(1,book.getName());
            bookStatement.setString(2,book.getPublisher());
            bookStatement.setInt(3,book.getPublishYear());
            bookStatement.setInt(4,book.getPageNumber());
            bookStatement.setString(5,book.getIsbn());
            bookStatement.setString(6,book.getLink());
            bookStatement.setInt(7,authorId); // ID автора получаем на вход для метода, остальная информация идёт из BookInfo.
            bookStatement.execute();
        }catch (SQLException se) {
            System.out.println("При добавлении книг соединение не установлено");
            se.printStackTrace();
        }
    }

    public List<Library> searchBook(String txt) {
        try(final Connection connection = getConnection();
            PreparedStatement searchStatement = connection.prepareStatement(
                    """
                        select b.book_name, b.publisher, b.year_of_publishing, b.page_number, b.isbn, b.link, a.auth_name from book b
                        left join author a
                        on b.auth_id = a.id
                        where lower(b.book_name) like ? or lower(a.auth_name) like ?
                    """
            ))
            {
                searchStatement.setString(1, "%" + txt + "%"); // используем 2 поиска: один по названию книги, второй по имени автора
                searchStatement.setString(2, "%" + txt + "%");
                final ResultSet resultSet = searchStatement.executeQuery();

                List<Library> result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Library(
                            resultSet.getString("auth_name"),
                            resultSet.getString("book_name"),
                            resultSet.getString("publisher"),
                            resultSet.getInt("year_of_publishing"),
                            resultSet.getInt("page_number"),
                            resultSet.getString("isbn"),
                            resultSet.getString("link")));
                }
                return result;
            }catch (SQLException se) {
            System.out.println("При поиске книг произошла ошибка.");
            se.printStackTrace();
        }
        return Collections.emptyList();
    }
}