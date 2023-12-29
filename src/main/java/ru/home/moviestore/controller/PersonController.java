package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.service.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;
}
