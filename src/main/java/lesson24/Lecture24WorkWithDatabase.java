package lesson24;

public class Lecture24WorkWithDatabase {
    /*
=============================================== SQL команды ===============================================
    Типы команд в SQL Data:
    Data Definition Language - позволяет создавать и изменять SQL таблицы.

    Команды:
        DDL - create;
            - alter; - изменение таблицы
            - drop; - удаление таблицы (drop database, drop table)
            - truncate; - высвобождение таблицы, т.е. удаление всей информации из таблицы
            - rename.

====== 1) CREATE
    Схема создания таблицы:
        CREATE TABLE <tbl> (
            <name><type<><restrictions>
            [CONSTRAINT <name><expr>]
        )

    пример ниже:
      " create table employee
        (
        emp_id int not null,
        emp_name varchar(255) not null,
        salary decimal null,
        department_id int null,

        constraint employee_department_id_fk
            foreign key (department_id) references department (id) "

    В Default можно проставлять базовые значения в таблицы, н-р базовая ЗП или город по умолчанию.

    PRIMARY KEY - устанавливает оганичение первичного ключа на столбец или группу столбцов.
    Первичный ключ может быть только один.

    FOREIGN KEY
        ON DELETE - команда, которая удаляет таблицу и связанную с ней таблицу.

====== 2) ALTER - изменение таблицы

    ALTER TABLE table_name
        ADD new_column_name_column_definition [FIRST| AFTER column_name];
        table_name "table name to modify"


========================================================================================================================

    Data Manipulation Language (DML) - язык манипуляции данными.

    Команды:
        DML - select; - выборка
            - update; - обновление
            - insert; - вставка
            - delete; - удаление
            - merge;
            - lock table.

==== INSERT
    INSERT INTO <tbl> VALUES (...);
    INSERT INTO <tbl> (<col>, <col>) VALUES (...);
    INSERT INTO <tbl> (<col>, <col>) VALUES (...), (...);

    пр-р:
    insert into department(id, name)
    values (2, 'Test')

==== UPDATE
    UPDATE <tbl> SET <col> = <expr> WHERE <expr>;
    <expr> (первый) может ссылаться на текущее значение столбца.
  ! Если не указывать WHERE, то замены будут произведены во всех названиях.

    пр-р:
    update department set name = 'Account'
    where id = 3

==== DELETE
    DELETE FROM <tbl> WHERE <expr>;

    пр-р:
    delete from department
    where id = 2

==== SELECT
    SELECT * FROM <tbl>; - показывает всё, что есть в таблице
    SELECT <col> FROM <tbl>;
    SELECT * FROM <tbl> WHERE <expr>;
    SELECT * FROM <tbl> LIMIT <limit>;
    SELECT * FROM <tbl> OFFSET <offset>;
    SELECT * FROM <tbl> ORDER BY <expr> ASC | DESC;

    пр-р:
    select id, name from department
    where id > 2;

    пр-р сортировки:
    select * from department
    order by id, name;

    При выборке и сопостовлению из 2-х таблиц применяется
    SELECT <col>, ..., <col> FROM <tbl> JOINT <tbl>

    пр-р:
    select e.emp_id, e.emp_name, e.salary, d.id, d.name
    from employee e
    right join department d

    Также есть RIGHT JOIN и LEFT JOINT:
    RIGHT JOINT - если данных в исходной таблице нет, то выводятся все значения из таблицы JOIN, а исходные данные
    указываются <null>

    LEFT JOINT - выводит все данные, которые есть в таблице FROM, а данные которых нет в таблице JOIN, указываются
    <null>

    SELECT DISTINCT <tbl> - выдаёт только уникальные значения, убирая повторы.



        DCL - grant;
            - revoke.

        TCL - commit;
            - rollback;
            - savepoint.

====================================== Архитектура JavaDataBaseConnectivity (JDBC) =====================================

    Connection

    Statement
        PreparedStatement

    Driver

    ResultSet
     */
}