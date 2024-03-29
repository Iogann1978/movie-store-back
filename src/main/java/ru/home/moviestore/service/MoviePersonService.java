package ru.home.moviestore.service;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoviePersonService {
    private static final Set<String> ROLES = Arrays.stream(MoviePerson.Role.values()).map(MoviePerson.Role::name).collect(Collectors.toSet());
    private static final Comparator<PersonDto> CMP1 = Comparator.comparing(p -> p.getSeriesCount() + p.getMoviesCount());
    private static final Comparator<PersonDto> CMP2 = CMP1.reversed().thenComparing(PersonDto::getName);
    private final MovieService movieService;
    private final PersonService personService;
    private final MoviePersonRepository moviePersonRepository;
    private final KinopoiskService kinopoiskService;

    public List<MoviePersonDto> getPersons(Long movieId) {
        return moviePersonRepository.findPersonsByMovieId(movieId)
                .stream().map(mp -> MoviePersonMapper.entityToDto(mp, movieService, personService))
                .collect(Collectors.toList());
    }

    public List<MoviePersonDto> getMovies(Long personId) {
        return moviePersonRepository.findMoviesByPersonId(personId)
                .stream().map(mp -> MoviePersonMapper.entityToDto(mp, movieService, personService))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveMoviePerson(MoviePerson moviePerson) {
        if (!moviePersonRepository.findAllByMovieIdAndPersonIdAndRole(moviePerson.getMovieId(), moviePerson.getPersonId(), moviePerson.getRole()).isPresent()) {
            moviePersonRepository.save(moviePerson);
        }
    }

    public void deleteByMovieId(Long movieId) {
        moviePersonRepository.deleteAllByMovieId(movieId);
    }

    public List<PersonDto> getPersons() {
        return personService.getPersons().stream()
                .sorted(CMP2)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getPersons(MoviePerson.Role role) {
        return personService.findAllByRole(role).stream()
                .map(PersonMapper::entityToDtoWithCount)
                .sorted(CMP2)
                .collect(Collectors.toList());
    }

    public List<PersonDto> getPersons(String name) {
        return personService.findAllByName(name).stream()
                .map(PersonMapper::entityToDtoWithCount)
                .sorted(CMP2)
                .collect(Collectors.toList());
    }

    @Transactional
    public void savePersons(Long movieId) {
        Set<StaffResponse> staffs = kinopoiskService.findPersons(movieId);
        if (!CollectionUtils.isEmpty(staffs)) {
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey().name()))
                    .filter(staff -> descriptFilter(staff.getDescription()))
                    .map(staff -> MoviePersonMapper.fromStaff(movieId, staff))
                    .forEach(this::saveMoviePerson);
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey().name()))
                    .map(PersonMapper::fromStaff)
                    .forEach(personService::savePerson);
        }
    }

    @Transactional
    public void deletePersons(Long movieId) {
        deleteByMovieId(movieId);
        personService.deleteWithNullMovie();
    }

    @Transactional
    public void saveMovie(MovieDto dto) {
        movieService.saveMovie(MovieMapper.dtoToEntity(dto));
        savePersons(dto.getId());
    }

    @Transactional
    public void deleteMovie(Long id) {
        deletePersons(id);
        movieService.deleteById(id);
    }

    private boolean descriptFilter(String description) {
        return StringUtils.isEmpty(description) || !description.contains("в титрах не указан");
    }
}
