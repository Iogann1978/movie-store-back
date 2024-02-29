package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final CountryService countryService;
    private final TagService tagService;
    private final DescriptService descriptService;
    private final KinopoiskService kinopoiskService;

    public List<MovieDto> getMovies() {
        return movieRepository.findAllMovies().stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getMovies(Boolean isSerial) {
        return movieRepository.findAllMovies(isSerial).stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getMovies(String title) {
        String toFind = String.format("%%%s%%", title.toLowerCase());
        return movieRepository.findAllMoviesByTitle(toFind).stream()
                .map(MovieMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<MovieDto> getMovie(Long id) {
        return movieRepository.existsById(id) ?
                movieRepository.findMovieById(id).map(MovieMapper::entityToDto) :
                kinopoiskService.findMovie(id);
    }

    @Transactional
    public void saveMovie(Movie movie) {
        if (!CollectionUtils.isEmpty(movie.getCountries())) {
            countryService.saveAll(movie.getCountries());
        }
        if (!CollectionUtils.isEmpty(movie.getTags())) {
            tagService.saveAll(movie.getTags());
        }
        movieRepository.save(movie);
        if (!CollectionUtils.isEmpty(movie.getDescripts())) {
            movie.getDescripts().stream().forEach(desc -> descriptService.save(movie, desc));
        }
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
