package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.kinopoisk.api.StaffApi;
import ru.home.moviestore.kinopoisk.model.StaffResponse;
import ru.home.moviestore.mapper.MoviePersonMapper;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private static final Set<String> ROLES = Arrays.stream(MoviePerson.Role.values()).map(MoviePerson.Role::name).collect(Collectors.toSet());
    private final PersonRepository personRepository;
    private final StaffApi staffApi;
    private final MoviePersonService moviePersonService;

    public Set<PersonDto> getPersons() {
        return personRepository.findAll().stream()
                .map(PersonMapper::entityToDto)
                .collect(Collectors.toSet());
    }

    public Optional<PersonDto> getPerson(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper::entityToDto);
    }

    public void savePerson(PersonDto dto) {
        personRepository.save(PersonMapper.dtoToEntity(dto));
    }

    public void savePersons(Long movieId) {
        List<StaffResponse> staffs = staffApi.apiV1StaffGet(movieId);
        if (!CollectionUtils.isEmpty(staffs)) {
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey()))
                    .map(staff -> MoviePersonMapper.fromStaff(movieId, staff))
                    .forEach(moviePersonService::saveMoviePerson);
            staffs.stream()
                    .filter(staff -> ROLES.contains(staff.getProfessionKey()))
                    .map(PersonMapper::fromStaff)
                    .forEach(this::savePerson);
        }
    }

    public void deletePersons(Long movieId) {
        moviePersonService.deleteByMovieId(movieId);
        List<Person> persons = personRepository.findNullMovie();
        if (!CollectionUtils.isEmpty(persons)) {
            personRepository.deleteAll(persons);
        }
    }
}
