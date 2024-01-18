package ru.home.moviestore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.service.DescriptService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/descript")
@Slf4j
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

    @PostMapping("/{id}")
    public void descriptUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file
    ) {
        try {
            DescriptDto descriptDto = DescriptDto.builder()
                    .text(file.getBytes())
                    .name(file.getOriginalFilename())
                    .build();
            descriptService.save(id, descriptDto);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
