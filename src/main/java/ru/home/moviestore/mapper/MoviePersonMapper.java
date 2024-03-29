package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.kinopoisk.model.StaffResponse;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.service.MovieService;
import ru.home.moviestore.service.PersonService;

import java.util.Optional;

@UtilityClass
public class MoviePersonMapper {
    public MoviePerson dtoToEntity(MoviePersonDto dto) {
        return MoviePerson.builder()
                .movieId(Optional.ofNullable(dto.getMovie()).map(MovieDto::getId).orElse(null))
                .personId(Optional.ofNullable(dto.getPerson()).map(PersonDto::getId).orElse(null))
                .role(MoviePerson.Role.values()[dto.getRole()])
                .description(dto.getDescription())
                .build();
    }

    public MoviePersonDto entityToDto(MoviePerson entity, MovieService movieService, PersonService personService) {
        MovieDto movieDto = movieService.getMovie(entity.getMovieId())
                .orElseGet(() -> MovieDto.builder().id(entity.getMovieId()).build());
        PersonDto personDto = personService.getPerson(entity.getPersonId())
                .orElseGet(() -> PersonDto.builder().id(entity.getPersonId()).build());
        return MoviePersonDto.builder()
                .movie(movieDto)
                .person(personDto)
                .role(entity.getRole().ordinal())
                .description(entity.getDescription())
                .build();
    }

    public MoviePerson fromStaff(Long movieId, StaffResponse staff) {
        return MoviePerson.builder()
                .movieId(movieId)
                .personId(staff.getStaffId())
                .description(staff.getDescription())
                .role(MoviePerson.Role.valueOf(staff.getProfessionKey().name()))
                .build();
    }
}
