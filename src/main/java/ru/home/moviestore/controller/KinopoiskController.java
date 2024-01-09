package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.service.KinopoiskService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "kinopoisk")
public class KinopoiskController {
    private final KinopoiskService kinopoiskService;

    @GetMapping("/{movieId}")
    public MovieDto getMovie(@PathVariable Long movieId) {
        return kinopoiskService.findMovie(movieId);
    }
}
