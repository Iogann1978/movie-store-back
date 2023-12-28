package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.model.Movie;

@UtilityClass
public class MovieMapper {
    public Movie dtoToEntity(MovieDto dto) {
        return Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .originTitle(dto.getOriginTitle())
                .externalRating(dto.getExternalRating())
                .internalRating(dto.getInternalRating())
                .duration(dto.getDuration())
                .year(dto.getYear())
                .serial(dto.getSerial())
                .state(Movie.State.valueOf(dto.getState()))
                .countries()
                .persons()
                .tags()
                .build();
    }

    public MovieDto entityToDto(Movie entity) {
        return MovieDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .originTitle(entity.getOriginTitle())
                .externalRating(entity.getExternalRating())
                .internalRating(entity.getInternalRating())
                .serial(entity.getSerial())
                .duration(entity.getDuration())
                .year(entity.getYear())
                .state(entity.getState().name())
                .countries()
                .persons()
                .tags()
                .build();
    }
}
