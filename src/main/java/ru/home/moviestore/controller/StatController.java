package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.service.StatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/stat")
public class StatController {
    private final StatService statService;

    @GetMapping
    public ResponseEntity<List<StatDto>> getStats() {
        List<StatDto> stats = statService.findAll();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/current")
    public ResponseEntity<StatDto> getCurrentStat() {
        StatDto statDto = statService.getStat();
        return ResponseEntity.ok(statDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatDto> getStat(@PathVariable Long id) {
        return statService.getStat(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public void addStat() {
        statService.addStat();
    }

    @DeleteMapping("/{id}")
    public void deleteStat(@PathVariable Long id) {
        statService.deleteStat(id);
    }
}
