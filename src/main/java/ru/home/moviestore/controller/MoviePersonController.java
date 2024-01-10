package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.service.MoviePersonService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "movie-person")
public class MoviePersonController {
    private final MoviePersonService moviePersonService;

    @GetMapping("/persons/{movieId}")
    public Set<MoviePersonDto> getPersons(@PathVariable Long movieId) {
        return moviePersonService.getPersons(movieId);
    }

    @GetMapping("/movies/{personId}")
    public Set<MoviePersonDto> getMovies(@PathVariable Long personId) {
        return moviePersonService.getMovies(personId);
    }
}
