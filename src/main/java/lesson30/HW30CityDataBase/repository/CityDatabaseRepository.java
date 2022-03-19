package lesson30.HW30CityDataBase.repository;

import lesson30.HW30CityDataBase.model.CityDataBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDatabaseRepository extends JpaRepository<CityDataBase, Integer> {

    @Query("select c from CityDataBase c " +
            "where c.cityNameEng = :name " +
            "or c.cityNameRus = :name")
    List<CityDataBase> findCitiesByName(String name);

    @Query("delete from CityDataBase c " +
            "where c.cityNameEng = :name " +
            "or c.cityNameRus = :name")
    List<CityDataBase> deleteCitiesByName(String name);
}
