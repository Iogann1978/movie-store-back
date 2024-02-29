package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.moviestore.dto.DescriptDto;
import ru.home.moviestore.mapper.DescriptMapper;
import ru.home.moviestore.model.Descript;
import ru.home.moviestore.model.Movie;
import ru.home.moviestore.repository.DescriptRepository;
import ru.home.moviestore.repository.MovieRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DescriptService {
    private final DescriptRepository descriptRepository;
    private final MovieRepository movieRepository;

    public Optional<DescriptDto> getDescript(Long id) {
        return descriptRepository.findById(id)
                .map(DescriptMapper::entityToDto);
    }

    public void deleteDescript(Long id) {
        descriptRepository.deleteById(id);
    }

    public void save(Long id, DescriptDto descriptDto) {
        Movie movie = movieRepository.findById(id).orElseGet(() -> Movie.builder().id(id).build());
        Descript descript = Descript.builder()
                .movie(movie)
                .name(descriptDto.getName())
                .text(descriptDto.getText())
                .build();
        descriptRepository.save(descript);
    }

    @Transactional
    public void save(Movie movie, Descript descript) {
        descript.setMovie(movie);
        descriptRepository.save(descript);
    }
}
