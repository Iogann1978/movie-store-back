package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.service.MoviePersonService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "movie-person")
public class MoviePersonController {
    private final MoviePersonService moviePersonService;

    @PutMapping
    public void saveMoviePersons(Set<MoviePersonDto> dtos) {
        dtos.stream().forEach(moviePersonService::saveMoviePerson);
    }
}
