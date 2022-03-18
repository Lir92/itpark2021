package lesson30.repository;

import lesson30.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
// Для работы достаточно просто объявить интерфейс и расширить его необходимым репозиторием.
// У репозитория указывается 2 параметра: 1 - класс определяющий таблицу, 2 - тип первичного ключа (String, int и т.д.
//
public interface GenreRepository extends JpaRepository<Genre, String> {
}