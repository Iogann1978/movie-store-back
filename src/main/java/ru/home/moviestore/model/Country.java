package ru.home.moviestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
public class Country {
    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "countries", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
