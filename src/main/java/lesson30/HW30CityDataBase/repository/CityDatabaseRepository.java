package lesson30.HW30CityDataBase.repository;

import lesson30.HW30CityDataBase.model.CityDataBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDatabaseRepository extends JpaRepository<CityDataBase, Integer> {


    @Query("select c from CityDataBase c " +
            "where c.cityNameEng = :name " +
            "or c.cityNameRus = :name")
    List<CityDataBase> findCityByName(@Param("name") String name);
}
