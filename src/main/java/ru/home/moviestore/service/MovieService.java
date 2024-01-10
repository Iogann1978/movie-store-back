package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.repository.MovieRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final PersonService personService;

    public Set<MovieDto> getMovies() {
        return movieRepository.findAllMovie().stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toSet());
    }

    public Optional<MovieDto> getMovie(Long id) {
        return movieRepository.findById(id)
                .map(MovieMapper::entityToDto);
    }

    public void saveMovie(MovieDto dto) {
        movieRepository.save(MovieMapper.dtoToEntity(dto));
        personService.savePersons(dto.getId());
    }
}
