package ru.home.moviestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.model.Stat;
import ru.home.moviestore.repository.StatRepository;

@Service
@RequiredArgsConstructor
public class StatService {
    private final StatRepository statRepository;

    public StatDto getStat() {
        Stat stat = statRepository.getStat();
        return StatDto.builder()
                .moviesCount(stat.getMoviesCount())
                .seriesCount(stat.getSeriesCount())
                .actorsCount(stat.getActorsCount())
                .directorsCount(stat.getDirectorsCount())
                .composersCount(stat.getComposersCount())
                .totalMoviesCount(stat.getTotalMoviesCount())
                .totalPersonsCount(stat.getTotalPersonsCount())
                .build();
    }
}
