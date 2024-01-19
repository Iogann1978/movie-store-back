package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.service.MoviePersonService;
import ru.home.moviestore.service.PersonService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/person")
public class PersonController {
    private final PersonService personService;
    private final MoviePersonService moviePersonService;

    @GetMapping
    public ResponseEntity<Set<PersonDto>> getMovies(@RequestParam("role") Integer roleIndex) {
        if (roleIndex < 0 || roleIndex >= MoviePerson.Role.values().length) {
            return ResponseEntity.badRequest().build();
        }

        MoviePerson.Role role = MoviePerson.Role.values()[roleIndex];
        Set<PersonDto> persons = moviePersonService.getPersons(role);
        return !CollectionUtils.isEmpty(persons) ?
                ResponseEntity.ok(persons) :
                ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id) {
        return personService.getPerson(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
