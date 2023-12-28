package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.service.MovieService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public Set<MovieDto> getMovies() {
        return movieService.getMovies();
    }
}
