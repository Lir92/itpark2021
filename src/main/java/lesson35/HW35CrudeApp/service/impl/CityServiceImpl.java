package lesson35.HW35CrudeApp.service.impl;

import lesson35.HW35CrudeApp.dto.CityDto;
import lesson35.HW35CrudeApp.dto.CityPageDto;
import lesson35.HW35CrudeApp.mapper.CityMapper;
import lesson35.HW35CrudeApp.model.City;
import lesson35.HW35CrudeApp.repository.CityRepository;
import lesson35.HW35CrudeApp.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    public CityPageDto getPage(Pageable pageable) {
        Page<City> currentPage = cityRepository.findAll(pageable);
        return new CityPageDto(cityMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CityDto> getByRuName(@NotEmpty String cityName) {
        return cityMapper.toOptionalDto(cityRepository.findById(cityName));
    }

    @Override
    @Transactional
    public CityDto save(@Valid CityDto city) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(city)));
    }

    @Override
    @Transactional
    public void deleteByName(/*@NotEmpty*/ String cityName) {
        cityRepository.deleteById(cityName);
    }
}
