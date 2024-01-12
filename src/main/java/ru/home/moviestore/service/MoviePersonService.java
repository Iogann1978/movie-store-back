package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.mapper.MoviePersonMapper;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.repository.MoviePersonRepository;
import ru.home.moviestore.repository.PersonRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoviePersonService {
    private final MovieService movieService;
    private final PersonService personService;
    private final MoviePersonRepository moviePersonRepository;

    public Set<MoviePersonDto> getPersons(Long movieId) {
        return moviePersonRepository.findPersonsByMovieId(movieId)
                .stream().map(mp -> MoviePersonMapper.entityToDto(mp, movieService, personService))
                .collect(Collectors.toSet());
    }

    public Set<MoviePersonDto> getMovies(Long personId) {
        return moviePersonRepository.findMoviesByPersonId(personId)
                .stream().map(mp -> MoviePersonMapper.entityToDto(mp, movieService, personService))
                .collect(Collectors.toSet());
    }

    public void saveMoviePerson(MoviePerson moviePerson) {
        if (!moviePersonRepository.findAllByMovieIdAndAndPersonIdAndRole(moviePerson.getMovieId(), moviePerson.getPersonId(), moviePerson.getRole()).isPresent()) {
            moviePersonRepository.save(moviePerson);
        }
    }

    public void deleteByMovieId(Long movieId) {
        moviePersonRepository.deleteAllByMovieId(movieId);
    }

    public Integer getMoviesCount(Long personId, MoviePerson.Role role) {
        return moviePersonRepository.getMoviesCountByPersonIdAndRole(personId, role);
    }

    public Integer getSeriesCount(Long personId, MoviePerson.Role role) {
        return moviePersonRepository.getSeriesCountByPersonIdAndRole(personId, role);
    }
}
