package ru.home.moviestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Country {
    @Id
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "countries", fetch = FetchType.LAZY)
    private Set<Movie> movies;
}
