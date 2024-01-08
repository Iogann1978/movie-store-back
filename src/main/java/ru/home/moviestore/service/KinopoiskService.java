package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.kinopoisk.api.FilmsApi;
import ru.home.moviestore.kinopoisk.model.Film;
import ru.home.moviestore.mapper.MovieMapper;

@Service
@RequiredArgsConstructor
public class KinopoiskService {
    private final FilmsApi filmsApi;

    public MovieDto findMovie(Long movieId) {
        Film film = filmsApi.apiV22FilmsIdGet(movieId.intValue());
        return MovieMapper.fromFilm(film);
    }
}
