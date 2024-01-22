package ru.home.moviestore.mapper;

import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.kinopoisk.model.StaffResponse;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.service.MoviePersonService;

import java.util.Optional;
import java.util.function.Predicate;

@UtilityClass
public class PersonMapper {
    public Person dtoToEntity(PersonDto dto) {
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .originName(Optional.ofNullable(dto.getOriginName()).orElseGet(dto::getName))
                .build();
    }

    public PersonDto entityToDto(Person entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .originName(entity.getOriginName())
                .moviesCount(0)
                .seriesCount(0)
                .build();
    }

    public PersonDto entityToDto(Person entity, MoviePerson.Role role, MoviePersonService moviePersonService) {
        Integer moviesCount = moviePersonService.getMoviesCount(entity.getId(), role);
        Integer seriesCount = moviePersonService.getSeriesCount(entity.getId(), role);
        return PersonDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .originName(entity.getOriginName())
                .moviesCount(moviesCount)
                .seriesCount(seriesCount)
                .build();
    }

    public PersonDto fromStaff(StaffResponse staff) {
        return PersonDto.builder()
                .id(staff.getStaffId())
                .name(Optional.ofNullable(staff.getNameRu()).filter(Predicate.not(StringUtils::isEmpty)).orElseGet(staff::getNameEn))
                .originName(staff.getNameEn())
                .build();
    }
}
