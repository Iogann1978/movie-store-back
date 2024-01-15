package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.model.MoviePerson;

import java.util.Set;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class StatService {
    private final MovieService movieService;
    private final PersonService personService;

    public StatDto getStat() {
        Set<MovieDto> movies = movieService.getMovies();
        Long totalMoviesCount = Long.valueOf(movies.size());
        Long moviesCount = movieService.getMovies().stream().filter(MovieDto::getSerial).count();
        Long seriesCount = movieService.getMovies().stream().filter(Predicate.not(MovieDto::getSerial)).count();
        Long totalPersonsCount = personService.getPersons().stream().count();
        Long actorsCount = personService.getPersons(MoviePerson.Role.ACTOR).stream().count();
        Long directosCount = personService.getPersons(MoviePerson.Role.DIRECTOR).stream().count();
        Long composersCount = personService.getPersons(MoviePerson.Role.COMPOSER).stream().count();
        return StatDto.builder()
                .moviesCount(moviesCount)
                .seriesCount(seriesCount)
                .actorsCount(actorsCount)
                .directorsCount(directosCount)
                .composersCount(composersCount)
                .totalMoviesCount(totalMoviesCount)
                .totalPersonsCount(totalPersonsCount)
                .build();
    }
}
