package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.kinopoisk.api.FilmsApi;
import ru.home.moviestore.kinopoisk.api.StaffApi;
import ru.home.moviestore.kinopoisk.model.Film;
import ru.home.moviestore.kinopoisk.model.StaffResponse;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.mapper.PersonMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KinopoiskService {
    private final FilmsApi filmsApi;
    private final StaffApi staffApi;

    public Optional<MovieDto> findMovie(Long movieId) {
        Film film = filmsApi.apiV22FilmsIdGet(movieId);
        return Optional.ofNullable(film).map(MovieMapper::fromFilm);
    }

    public Set<PersonDto> findPersons(Long movieId) {
        List<StaffResponse> staffs = staffApi.apiV1StaffGet(movieId);
        return CollectionUtils.isEmpty(staffs) ? Collections.EMPTY_SET :
                staffs.stream().map(PersonMapper::fromStaff).collect(Collectors.toSet());
    }
}
