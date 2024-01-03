package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.model.Country;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.model.Tag;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {
    public Movie dtoToEntity(MovieDto dto) {
        return Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .originTitle(Optional.ofNullable(dto).map(MovieDto::getOriginTitle).orElseGet(dto::getTitle))
                .externalRating(dto.getExternalRating())
                .internalRating(dto.getInternalRating())
                .duration(dto.getDuration())
                .year(dto.getYear())
                .serial(dto.getSerial())
                .state(Movie.State.valueOf(dto.getState()))
                .countries(getContries(dto.getCountries()))
                .tags(getTags(dto.getTags()))
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
                .countries(getContriesDto(entity.getCountries()))
                .tags(getTagsDto(entity.getTags()))
                .build();
    }

    private Set<String> getContriesDto(Set<Country> countries) {
        return countries.stream().map(Country::getName).collect(Collectors.toSet());
    }

    private Set<String> getTagsDto(Set<Tag> tags) {
        return tags.stream().map(Tag::getName).collect(Collectors.toSet());
    }

    private Set<Country> getContries(Set<String> countries) {
        return countries.stream()
                .map(country -> Country.builder().name(country).build())
                .collect(Collectors.toSet());
    }

    private Set<Tag> getTags(Set<String> tags) {
        return tags.stream()
                .map(tag -> Tag.builder().name(tag).build())
                .collect(Collectors.toSet());
    }
}
