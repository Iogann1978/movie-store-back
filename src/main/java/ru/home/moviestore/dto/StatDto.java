package ru.home.moviestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatDto {
    private Long moviesCount;
    private Long seriesCount;
    private Long actorsCount;
    private Long directorsCount;
    private Long composersCount;
    private Long totalMoviesCount;
    private Long totalPersonsCount;
}
