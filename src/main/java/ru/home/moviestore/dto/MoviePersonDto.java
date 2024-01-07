package ru.home.moviestore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MoviePersonDto {
    private MovieDto movie;
    private PersonDto person;
    private String role;
    private String description;
}
