package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@Entity
@IdClass(PersonId.class)
public class Person {
    @Id
    private Long id;
    @Id
    private PersonId.Role role;
    @Column(nullable = false)
    private String name;
    @ToString.Exclude
    @ManyToMany(mappedBy = "persons", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
