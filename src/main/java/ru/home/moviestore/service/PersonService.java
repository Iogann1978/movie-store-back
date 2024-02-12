package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Set<PersonDto> getPersons() {
        return personRepository.findAll().stream()
                .map(PersonMapper::entityToDto)
                .collect(Collectors.toSet());
    }

    public Optional<PersonDto> getPerson(Long id) {
        return personRepository.findPerson(id)
                .map(PersonMapper::entityToDtoWithCount);
    }

    public List<Person> findAllByRole(MoviePerson.Role role) {
        return personRepository.findAllByRole(role).stream()
                .collect(Collectors.toList());
    }

    public List<Person> findAllByName(String name) {
        String toFind = String.format("%%%s%%", name.toLowerCase());
        return personRepository.findAllByName(toFind).stream()
                .collect(Collectors.toList());
    }

    public void deleteWithNullMovie() {
        List<Person> persons = personRepository.findNullMovie();
        if (!CollectionUtils.isEmpty(persons)) {
            personRepository.deleteAll(persons);
        }
    }

    public void savePerson(PersonDto dto) {
        personRepository.save(PersonMapper.dtoToEntity(dto));
    }

}
