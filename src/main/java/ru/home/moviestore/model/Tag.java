package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {
    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
