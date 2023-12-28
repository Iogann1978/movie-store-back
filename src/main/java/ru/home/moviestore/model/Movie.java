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
public class Movie {
    public enum State {
        SEEN, PLANNED, LEFT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String originTitle;
    @Column(nullable = false)
    private Integer externalRating;
    @Column(nullable = false)
    private Integer internalRating;
    private Integer year;
    @Column(nullable = false)
    private State state;
    private Integer duration;
    @Column(nullable = false)
    private Boolean serial;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_TAG", joinColumns = {@JoinColumn(name = "MOVIE_ID")}, inverseJoinColumns = {@JoinColumn(name = "NAME")})
    private Set<Tag> tags;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_COUNTRY", joinColumns = {@JoinColumn(name = "MOVIE_ID")}, inverseJoinColumns = {@JoinColumn(name = "NAME")})
    private Set<Country> countries;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MOVIE_PERSON", joinColumns = {@JoinColumn(name = "MOVIE_ID")}, inverseJoinColumns = {@JoinColumn(name = "ID"), @JoinColumn(name = "ROLE")})
    private Set<Person> persons;
    @ToString.Exclude
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Descript> descripts;
}
