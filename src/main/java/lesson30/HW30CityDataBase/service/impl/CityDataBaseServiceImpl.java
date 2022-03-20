package lesson30.HW30CityDataBase.service.impl;

import lesson30.HW30CityDataBase.model.CityDataBase;
import lesson30.HW30CityDataBase.repository.CityDatabaseRepository;
import lesson30.HW30CityDataBase.service.CityDataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityDataBaseServiceImpl implements CityDataBaseService {

    private final CityDatabaseRepository cityRepository;

    @Override
    public CityDataBase saveCity(CityDataBase cityDataBase) {
        return cityRepository.save(cityDataBase);
    }

    @Override
    public Optional<CityDataBase> findCityByCode(Integer code) {
        return cityRepository.findById(code);
    }

    @Override
    public List<CityDataBase> findCitiesByName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public void deleteCityByCode(Integer code) {
        cityRepository.deleteById(code);
    }
}
