package ru.home.moviestore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class MoviePersonDto {
    private Long movieId;
    private PersonDto person;
    private String role;
}
