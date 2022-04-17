package lesson35.HW35CrudeApp.service;

import lesson35.HW35CrudeApp.dto.CityDto;
import lesson35.HW35CrudeApp.dto.CityPageDto;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface CityService {

    List<CityDto> findAll();
    CityPageDto getPage(Pageable pageable);
    Optional<CityDto> getByRuName(@NotEmpty String cityName);
    CityDto save (@Valid CityDto city);
    void deleteByName (String cityName);
}
