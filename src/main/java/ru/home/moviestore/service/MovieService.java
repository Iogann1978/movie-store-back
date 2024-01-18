package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.repository.MovieRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final PersonService personService;
    private final KinopoiskService kinopoiskService;

    public Set<MovieDto> getMovies() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toSet());
    }

    public Set<MovieDto> getMovies(Boolean isSerial) {
        return movieRepository.findAllMovies(isSerial).stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toSet());
    }

    public Optional<MovieDto> getMovie(Long id) {
        return movieRepository.existsById(id) ?
                movieRepository.findById(id).map(MovieMapper::entityToDto) :
                kinopoiskService.findMovie(id);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
