package lesson35.HW35CrudeApp.mapper;

import lesson35.HW35CrudeApp.dto.CityDto;
import lesson35.HW35CrudeApp.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "ruName", source = "entity.ruName")
    @Mapping(target = "enName", source = "entity.enName")
    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "population", source = "entity.population")
    CityDto toDto(City entity);

    @Mapping(target = "ruName", source = "dto.ruName")
    @Mapping(target = "enName", source = "dto.enName")
    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "population", source = "dto.population")
    City toEntity (CityDto dto);

    default List<CityDto> toDtos(List<City> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<CityDto> toOptionalDto(Optional<City> entity) {
        return entity.map(this::toDto);
    }
}
