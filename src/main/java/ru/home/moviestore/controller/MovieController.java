package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        return movieService.getMovie(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public void saveMovie(@RequestBody MovieDto dto) {
        movieService.saveMovie(dto);
    }
}
