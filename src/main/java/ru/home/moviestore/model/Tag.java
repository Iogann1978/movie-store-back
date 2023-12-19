package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Set;

@Entity
public class Tag {
    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
