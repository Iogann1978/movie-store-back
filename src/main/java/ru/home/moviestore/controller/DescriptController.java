package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.service.DescriptService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/descript")
public class DescriptController {
    private final DescriptService descriptService;

    @GetMapping("/{id}")
    public ResponseEntity<DescriptDto> getDescripts(@PathVariable Long id) {
        return descriptService.getDescript(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteDescripts(@PathVariable Long id) {
        descriptService.deleteDescript(id);
    }
}
