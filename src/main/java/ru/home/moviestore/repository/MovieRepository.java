package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.serial = true ORDER BY m.title")
    List<Movie> findAllSerial();
    @Query("SELECT m FROM Movie m WHERE m.serial = false ORDER BY m.title")
    List<Movie> findAllMovie();
}
