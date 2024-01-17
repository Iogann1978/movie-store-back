package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.mapper.DescriptMapper;
import ru.home.moviestore.repository.DescriptRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DescriptService {
    private final DescriptRepository descriptRepository;

    public Optional<DescriptDto> getDescript(Long id) {
        return descriptRepository.findById(id)
                .map(DescriptMapper::entityToDto);
    }

    public void deleteDescript(Long id) {
        descriptRepository.deleteById(id);
    }
}
