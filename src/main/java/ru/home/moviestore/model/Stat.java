package ru.home.moviestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stat {
    @Id
    private Long id;
    private Long moviesCount;
    private Long seriesCount;
    private Long actorsCount;
    private Long directorsCount;
    private Long composersCount;
    private Long totalMoviesCount;
    private Long totalPersonsCount;
}
