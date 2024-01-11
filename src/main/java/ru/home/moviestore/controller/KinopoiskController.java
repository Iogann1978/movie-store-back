package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.service.KinopoiskService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "kinopoisk")
public class KinopoiskController {
    private final KinopoiskService kinopoiskService;

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long movieId) {
        return kinopoiskService.findMovie(movieId).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<Set<PersonDto>> getPersons(@PathVariable Long movieId) {
        Set<PersonDto> persons = kinopoiskService.findPersons(movieId);
        return !CollectionUtils.isEmpty(persons) ?
                ResponseEntity.ok(persons) :
                ResponseEntity.noContent().build();
    }
}
