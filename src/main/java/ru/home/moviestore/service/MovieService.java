package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.repository.MovieRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Set<MovieDto> getMovies() {
        return movieRepository.findAllMovie().stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toSet());
    }
}
