package lesson30.HW30CityDataBase.service;

import lesson30.HW30CityDataBase.model.CityDataBase;
import lesson30.HW30CityDataBase.repository.CityDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityDataBaseServiceImpl implements CityDataBaseService{

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
    public void deleteCityByCode(Integer code) {
        cityRepository.deleteById(code);
    }
}
