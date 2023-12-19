package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllBySerialTrueOrderByTitle();
    List<Movie> findAllBySerialFalseOrderByTitle();
}
