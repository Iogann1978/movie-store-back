package ru.home.moviestore.controller;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.service.MoviePersonService;
import ru.home.moviestore.service.MovieService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/movie")
public class MovieController {
    private final MovieService movieService;
    private final MoviePersonService moviePersonService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies(
            @RequestParam(required = false) Boolean isSerial,
            @RequestParam(required = false) String title
    ) {
        List<MovieDto> movies = Collections.EMPTY_LIST;
        if (isSerial != null) {
            movies = movieService.getMovies(isSerial);
        } else if (StringUtils.isNotEmpty(title)) {
            movies = movieService.getMovies(title);
        } else {
            movies = movieService.getMovies();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        return movieService.getMovie(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public void saveMovie(@RequestBody MovieDto dto) {
        moviePersonService.saveMovie(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        moviePersonService.deleteMovie(id);
    }
}
