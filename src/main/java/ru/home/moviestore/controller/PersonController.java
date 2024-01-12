package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.service.PersonService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<Set<PersonDto>> getMovies(@RequestParam Integer roleIndex) {
        if (roleIndex < 0 || roleIndex >= MoviePerson.Role.values().length) {
            return ResponseEntity.badRequest().build();
        }

        MoviePerson.Role role = MoviePerson.Role.values()[roleIndex];
        Set<PersonDto> persons = personService.getPersons(role);
        return !CollectionUtils.isEmpty(persons) ?
                ResponseEntity.ok(persons) :
                ResponseEntity.noContent().build();
    }
}
