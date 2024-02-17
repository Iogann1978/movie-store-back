package ru.home.moviestore.controller;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.service.MoviePersonService;
import ru.home.moviestore.service.PersonService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/person")
public class PersonController {
    private final PersonService personService;
    private final MoviePersonService moviePersonService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons(
            @RequestParam(name = "role", required = false) Integer roleIndex,
            @RequestParam(required = false) String name
    ) {
        List<PersonDto> persons = Collections.EMPTY_LIST;
        if (roleIndex != null) {
            if (roleIndex < 0 || roleIndex >= MoviePerson.Role.values().length) {
                return ResponseEntity.badRequest().build();
            }
            MoviePerson.Role role = MoviePerson.Role.values()[roleIndex];
            persons = moviePersonService.getPersons(role);
        } else if (StringUtils.isNotEmpty(name)) {
            persons = moviePersonService.getPersons(name);
        } else {
            persons = moviePersonService.getPersons();
        }

        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long id) {
        return personService.getPerson(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
