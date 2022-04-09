package lesson35.mapper;

import lesson35.dto.GenreDto;
import lesson35.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring") // при использовании меппера в Spring Boot приложении необходимо приписывать componentModel = "spring", что бы корректно создавался бин меппера.
// Сама по себе аннотаци @Mapper не создаёт бин для спринга.
public interface GenreMapper {

    @Mapping(target = "code", source = "entity.code")
    @Mapping(target = "name", source = "entity.name")
    GenreDto toDto(Genre entity);

    @Mapping(target = "code", source = "dto.code")
    @Mapping(target = "name", source = "dto.name")
    Genre toEntity(GenreDto dto);

    default List<GenreDto> toDtos(List<Genre> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<GenreDto> toOptionalDto(Optional<Genre> entity) {
        return entity.map(this::toDto);
    }
}