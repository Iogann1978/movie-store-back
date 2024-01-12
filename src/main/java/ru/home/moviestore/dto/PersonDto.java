package ru.home.moviestore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String originName;
    private Integer moviesCount;
    private Integer seriesCount;
}
