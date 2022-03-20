package lesson30.HW30CityDataBase.service;

import lesson30.HW30CityDataBase.model.CityDataBase;

import java.util.List;
import java.util.Optional;

public interface CityDataBaseService {

    CityDataBase saveCity(CityDataBase cityDataBase);

    Optional<CityDataBase> findCityByCode(Integer code);

    List<CityDataBase> findCitiesByName(String name);

    void deleteCityByCode(Integer code);
}
