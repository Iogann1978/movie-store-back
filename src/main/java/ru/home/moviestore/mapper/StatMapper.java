package ru.home.moviestore.mapper;

import lombok.experimental.UtilityClass;
import ru.home.moviestore.dto.StatDto;
import ru.home.moviestore.model.Stat;

@UtilityClass
public class StatMapper {
    public StatDto entityToDto(Stat entity, String bests) {
        return StatDto.builder()
            .moviesCount(entity.getMoviesCount())
            .seriesCount(entity.getSeriesCount())
            .actorsCount(entity.getActorsCount())
            .directorsCount(entity.getDirectorsCount())
            .composersCount(entity.getComposersCount())
            .totalMoviesCount(entity.getTotalMoviesCount())
            .totalPersonsCount(entity.getTotalPersonsCount())
            .bests(bests)
            .build();
    }

    public StatDto entityToDto(Stat entity) {
        return StatDto.builder()
            .id(entity.getId())
            .moviesCount(entity.getMoviesCount())
            .seriesCount(entity.getSeriesCount())
            .actorsCount(entity.getActorsCount())
            .directorsCount(entity.getDirectorsCount())
            .composersCount(entity.getComposersCount())
            .totalMoviesCount(entity.getTotalMoviesCount())
            .totalPersonsCount(entity.getTotalPersonsCount())
            .bests(entity.getBests())
            .build();
    }
}
