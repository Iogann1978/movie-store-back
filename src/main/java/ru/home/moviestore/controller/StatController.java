package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.service.StatService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/stat")
public class StatController {
    private final StatService statService;

    @GetMapping
    public ResponseEntity<StatDto> getMovie() {
        StatDto statDto = statService.getStat();
        return ResponseEntity.ok(statDto);
    }
}
