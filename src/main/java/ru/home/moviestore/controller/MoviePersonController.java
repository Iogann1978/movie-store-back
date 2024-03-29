package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.service.MoviePersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/movie-person")
public class MoviePersonController {
    private final MoviePersonService moviePersonService;

    @GetMapping("/persons/{movieId}")
    public ResponseEntity<List<MoviePersonDto>> getPersons(@PathVariable Long movieId) {
        List<MoviePersonDto> mps = moviePersonService.getPersons(movieId);
        return ResponseEntity.ok(mps);
    }

    @GetMapping("/movies/{personId}")
    public ResponseEntity<List<MoviePersonDto>> getMovies(@PathVariable Long personId) {
        List<MoviePersonDto> mps = moviePersonService.getMovies(personId);
        return ResponseEntity.ok(mps);
    }
}
