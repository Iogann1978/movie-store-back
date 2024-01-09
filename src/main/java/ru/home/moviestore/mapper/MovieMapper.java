package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.kinopoisk.model.Film;
import ru.home.moviestore.kinopoisk.model.Genre;
import ru.home.moviestore.model.Country;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.model.Tag;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {
    public Movie dtoToEntity(MovieDto dto) {
        return Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .originTitle(Optional.ofNullable(dto.getOriginTitle()).orElseGet(dto::getTitle))
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

    public MovieDto fromFilm(Film film) {
        return MovieDto.builder()
                .id(film.getKinopoiskId().longValue())
                .title(film.getNameRu())
                .originTitle(Optional.ofNullable(film.getNameOriginal()).orElseGet(film::getNameEn))
                .year(Optional.ofNullable(film.getYear()).map(Long::intValue).orElse(null))
                .serial(film.getSerial())
                .externalRating(getRating(film))
                .tags(getTags(film.getGenres()))
                .countries(getCountries(film.getCountries()))
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

    private Set<String> getTags(List<Genre> genres) {
        return genres.stream().map(Genre::getGenre).collect(Collectors.toSet());
    }

    private Set<String> getCountries(List<ru.home.moviestore.kinopoisk.model.Country> countries) {
        return countries.stream().map(ru.home.moviestore.kinopoisk.model.Country::getCountry).collect(Collectors.toSet());
    }

    private Integer getRating(Film film) {
        return Optional.ofNullable(film.getRatingKinopoisk())
                .map(rating -> rating.divide(BigDecimal.valueOf(2.0d), RoundingMode.HALF_UP))
                .map(BigDecimal::intValue)
                .orElse(0);
    }
}
