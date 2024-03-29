package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(columnList = "MOVIE_ID"),
        @Index(columnList = "PERSON_ID"),
        @Index(columnList = "ROLE")
})
public class MoviePerson {
    public enum Role {
        ACTOR, DIRECTOR, COMPOSER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long movieId;
    private Long personId;
    private Role role;
    private String description;
}
