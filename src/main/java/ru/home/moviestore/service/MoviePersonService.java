package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.kinopoisk.model.StaffResponse;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.mapper.MoviePersonMapper;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.repository.MoviePersonRepository;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoviePersonService {
    private static final Set<String> ROLES = Arrays.stream(MoviePerson.Role.values()).map(MoviePerson.Role::name).collect(Collectors.toSet());
    private final MovieService movieService;
    private final PersonService personService;
    private final MoviePersonRepository moviePersonRepository;
    private final KinopoiskService kinopoiskService;

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
        if (!moviePersonRepository.findAllByMovieIdAndPersonIdAndRole(moviePerson.getMovieId(), moviePerson.getPersonId(), moviePerson.getRole()).isPresent()) {
            moviePersonRepository.save(moviePerson);
        }
    }

    public void deleteByMovieId(Long movieId) {
        moviePersonRepository.deleteAllByMovieId(movieId);
    }

    public Integer getMoviesCount(Long personId, MoviePerson.Role role, boolean isSerial) {
        return moviePersonRepository.getMoviesCountByPersonIdAndRole(personId, role, isSerial);
    }

    public Set<PersonDto> getPersons(MoviePerson.Role role) {
        return personService.findAllByRole(role).stream()
                .map(person -> PersonMapper.entityToDto(person, role, this))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void savePersons(Long movieId) {
        Set<StaffResponse> staffs = kinopoiskService.findPersons(movieId);
        if (!CollectionUtils.isEmpty(staffs)) {
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey().name()))
                    .map(staff -> MoviePersonMapper.fromStaff(movieId, staff))
                    .forEach(this::saveMoviePerson);
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey().name()))
                    .map(PersonMapper::fromStaff)
                    .forEach(personService::savePerson);
        }
    }

    public void deletePersons(Long movieId) {
        deleteByMovieId(movieId);
        personService.deleteWithNullMovie();
    }

    public void saveMovie(MovieDto dto) {
        movieService.saveMovie(MovieMapper.dtoToEntity(dto));
        savePersons(dto.getId());
    }

    public void deleteMovie(Long id) {
        deletePersons(id);
        movieService.deleteById(id);
    }
}
