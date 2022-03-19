package lesson30.HW30CityDataBase.shell;

import lesson30.HW30CityDataBase.model.CityDataBase;
import lesson30.HW30CityDataBase.repository.CityDatabaseRepository;
import lesson30.HW30CityDataBase.service.CityDataBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class CityDataBaseInteraction {

    private final CityDataBaseService cityService;
    private final CityDatabaseRepository cityRepository;

    @ShellMethod(value = "Add city", key = {"add", "ac"})
    public void addCity(
            @ShellOption({"-c", "--cc"}) Integer cityCode,
            @ShellOption({"-rn", "--runame"}) String cityRuName,
            @ShellOption({"-en", "--enname"}) String cityEnName,
            @ShellOption({"-p", "--pop"}) long population){
        final CityDataBase newCity = new CityDataBase(cityCode, cityRuName, cityEnName, population);
        newCity.setPopulation(population);
        cityService.saveCity(newCity);
    }

    @ShellMethod(value = "Update city", key = "uc")
    public void updateCity(
            @ShellOption({"-c", "--cc"}) Integer cityCode,
            @ShellOption({"-rn", "--runame"}) String cityRuName,
            @ShellOption({"-en", "--enname"}) String cityEnName,
            @ShellOption(value = {"-p", "--pop"}, defaultValue = ShellOption.NULL) Long population) {
        cityService.findCityByCode(cityCode).ifPresent(newCity -> {
            newCity.setCityNameRus(cityRuName);
            newCity.setCityNameEng(cityEnName);
            if (population != null) {
                newCity.setPopulation(population);
            }
            cityService.saveCity(newCity);
            log.debug("Город {} обновлён", newCity);
        });
    }

    @ShellMethod(value = "Find city", key = "fc")
    public void findCity(
            @ShellOption({"-c", "--code"}) Integer cityCode) {
        cityService.findCityByCode(cityCode).ifPresentOrElse(
                city -> log.info("Вы искали город {}", city),
                () -> log.warn("Города с кодом {} нет в БД", cityCode)
        );
    }

    @ShellMethod(value = "Delete city", key = "dc")
    public void deleteCity(
            @ShellOption({"-c", "--code"}) Integer cityCode) {
        cityService.deleteCityByCode(cityCode);
        log.debug("Город с кодом {} был удалён", cityCode);
    }
}
