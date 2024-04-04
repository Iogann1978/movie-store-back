package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.mapper.StatMapper;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.model.Stat;
import ru.home.moviestore.repository.MovieRepository;
import ru.home.moviestore.repository.PersonRepository;
import ru.home.moviestore.repository.StatRepository;

@Service
@RequiredArgsConstructor
public class StatService {
    private static final String EMPTY_STRING = "Запись не найдена";
    private final StatRepository statRepository;
    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    public StatDto getStat() {
        Stat stat = statRepository.getStat();
        String bests = getBests();
        return StatMapper.entityToDto(stat, bests);
    }

    private String getBests() {
        String bestMovie = movieRepository.findBestMovie(false)
                .map(Movie::getTitle)
                .orElse(EMPTY_STRING);
        String bestSeries = movieRepository.findBestMovie(true)
                .map(Movie::getTitle)
                .orElse(EMPTY_STRING);
        String bestActor = personRepository.findBestPersonByRole(MoviePerson.Role.ACTOR)
                .map(Person::getName)
                .orElse(EMPTY_STRING);
        String bestDirector = personRepository.findBestPersonByRole(MoviePerson.Role.DIRECTOR)
                .map(Person::getName)
                .orElse(EMPTY_STRING);
        String bestComposer = personRepository.findBestPersonByRole(MoviePerson.Role.COMPOSER)
                .map(Person::getName)
                .orElse(EMPTY_STRING);

        StringBuilder sb = new StringBuilder();
        sb.append("<dl>\n");
        sb.append("<dt>Лучший фильм</dt>\n");
        sb.append("<dd>");
        sb.append(bestMovie);
        sb.append("</dd>\n");
        sb.append("<dt>Лучший сериал</dt>\n");
        sb.append("<dd>");
        sb.append(bestSeries);
        sb.append("</dd>\n");
        sb.append("<dt>Лучший актёр</dt>\n");
        sb.append("<dd>");
        sb.append(bestActor);
        sb.append("</dd>\n");
        sb.append("<dt>Лучший режиссёр</dt>\n");
        sb.append("<dd>");
        sb.append(bestDirector);
        sb.append("</dd>\n");
        sb.append("<dt>Лучший композитор</dt>\n");
        sb.append("<dd>");
        sb.append(bestComposer);
        sb.append("</dd>\n");
        sb.append("</dl>");
        return sb.toString();
    }
}
