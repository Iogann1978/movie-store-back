package ru.home.moviestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String originName;
    private Long moviesCount;
    private Long seriesCount;
}
