package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.repository.PersonRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Optional<PersonDto> getPerson(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper::entityToDto);
    }
    public void savePerson(PersonDto dto) {
        personRepository.save(PersonMapper.dtoToEntity(dto));
    }
}
