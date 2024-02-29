package ru.home.moviestore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoviePersonDto {
    private MovieDto movie;
    private PersonDto person;
    private Integer role;
    private String description;
}
