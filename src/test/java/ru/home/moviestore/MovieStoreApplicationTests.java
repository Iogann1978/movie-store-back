package ru.home.moviestore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import ru.home.moviestore.dto.MovieDto;
import ru.home.moviestore.dto.MoviePersonDto;
import ru.home.moviestore.dto.PersonDto;
import ru.home.moviestore.mapper.MovieMapper;
import ru.home.moviestore.mapper.MoviePersonMapper;
import ru.home.moviestore.service.MoviePersonService;
import ru.home.moviestore.service.MovieService;
import ru.home.moviestore.service.PersonService;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class MovieStoreApplicationTests {
    private static final String FILENAME_MOVIES = "import/movies.json";
    private static final String FILENAME_PERSONS = "import/persons.json";
    private static final String FILENAME_MP = "import/mp_%d.json";
    private static final ObjectMapper OBJECT_MAPPER = new JsonMapper().registerModule(new JsonNullableModule());
    @Autowired
    private MovieService movieService;
    @Autowired
    private PersonService personService;
    @Autowired
    private MoviePersonService moviePersonService;

    //@Test
    void importTest() throws IOException {
        List<MovieDto> movies = movieService.getMovies();
        OBJECT_MAPPER.writeValue(Paths.get(FILENAME_MOVIES).toFile(), movies);

        Set<PersonDto> persons = personService.getPersons();
        OBJECT_MAPPER.writeValue(Paths.get(FILENAME_PERSONS).toFile(), persons);

        movies.stream().map(MovieDto::getId).forEach(id -> {
            List<MoviePersonDto> mpList = moviePersonService.getPersons(id);
            try {
                OBJECT_MAPPER.writeValue(Paths.get(String.format(FILENAME_MP, id)).toFile(), mpList);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        });
    }

    //@Test
    void exportMoviesTest() throws IOException {
        TypeReference<List<MovieDto>> moviesType = new TypeReference<>() {};
        List<MovieDto> movies = OBJECT_MAPPER.readValue(Paths.get(FILENAME_MOVIES).toFile(), moviesType);
        movies.stream().map(MovieMapper::dtoToEntity).forEach(movieService::saveMovie);
    }

    //@Test
    void exportTest() throws IOException {
        TypeReference<List<MovieDto>> moviesType = new TypeReference<>() {};
        List<MovieDto> movies = OBJECT_MAPPER.readValue(Paths.get(FILENAME_MOVIES).toFile(), moviesType);
        TypeReference<List<PersonDto>> personsType = new TypeReference<>() {};
        Map<Long, PersonDto> persons = OBJECT_MAPPER.readValue(Paths.get(FILENAME_PERSONS).toFile(), personsType).stream()
                .collect(Collectors.toMap(PersonDto::getId, Function.identity()));

        TypeReference<List<MoviePersonDto>> mpType = new TypeReference<>() {};
        for (int i = 0; i < movies.size(); ++i) {
            log.info("{} {}", i+1, movies.size());
            Optional.ofNullable(movies.get(i)).map(MovieDto::getId)
                    .ifPresentOrElse(movieId -> {
                        try {
                            List<MoviePersonDto>  mpList = OBJECT_MAPPER.readValue(Paths.get(String.format(FILENAME_MP, movieId)).toFile(), mpType);
                            if (!CollectionUtils.isEmpty(mpList)) {
                                mpList.stream().map(MoviePersonMapper::dtoToEntity)
                                        .filter(mp -> descriptFilter(mp.getDescription()))
                                        .forEach(mp -> {
                                            if (persons.containsKey(mp.getPersonId())) {
                                                personService.savePerson(persons.get(mp.getPersonId()));
                                                moviePersonService.saveMoviePerson(mp);
                                            } else {
                                                log.error("person is empty for movieId: {}", movieId);
                                            }
                                        });
                            }
                        } catch (IOException e) {
                            log.error(e.getMessage(), e);
                        }
                    }, () -> {
                        log.error("movieId is null");
                    });
        }
    }

    private boolean descriptFilter(String description) {
        return StringUtils.isEmpty(description) || !description.contains("в титрах не указан");
    }
}
