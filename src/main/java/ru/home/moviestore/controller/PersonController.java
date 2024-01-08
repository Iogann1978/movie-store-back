package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.service.PersonService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public Set<PersonDto> getMovies() {
        return personService.getPersons();
    }
}
