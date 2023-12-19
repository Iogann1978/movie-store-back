package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Entity
@IdClass(PersonId.class)
@Getter
public class Person {
    @Id
    @Column(nullable = false)
    private String name;
    @Id
    @Column(nullable = false)
    private PersonId.Role role;
    @ToString.Exclude
    @ManyToMany(mappedBy = "persons", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
