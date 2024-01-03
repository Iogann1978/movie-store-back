package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.model.Person;

import java.util.Optional;

@UtilityClass
public class PersonMapper {
    public Person dtoToEntity(PersonDto dto) {
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .originName(Optional.ofNullable(dto).map(PersonDto::getOriginName).orElseGet(dto::getName))
                .build();
    }

    public PersonDto entityToDto(Person entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
