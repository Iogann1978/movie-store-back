package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.mapper.MoviePersonMapper;
import ru.home.moviestore.mapper.PersonMapper;
import ru.home.moviestore.repository.MoviePersonRepository;
import ru.home.moviestore.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class MoviePersonService {
    private final PersonRepository personRepository;
    private final MoviePersonRepository moviePersonRepository;

    public void saveMoviePerson(MoviePersonDto dto) {
        personRepository.save(PersonMapper.dtoToEntity(dto.getPerson()));
        moviePersonRepository.save(MoviePersonMapper.dtoToEntity(dto));
    }
}
