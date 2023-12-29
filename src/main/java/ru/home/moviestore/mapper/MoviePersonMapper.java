package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.model.MoviePerson;

@UtilityClass
public class MoviePersonMapper {
    public MoviePerson dtoToEntity(MoviePersonDto dto) {
        return MoviePerson.builder()
                .movieId(dto.getMovieId())
                .personId(dto.getPerson().getId())
                .role(MoviePerson.Role.valueOf(dto.getRole()))
                .build();
    }
}
