package ru.home.moviestore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatDto {
    private Long moviesCount;
    private Long seriesCount;
    private Long actorsCount;
    private Long directorsCount;
    private Long composersCount;
    private Long totalMoviesCount;
    private Long totalPersonsCount;
}
