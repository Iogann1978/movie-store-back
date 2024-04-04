package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @EntityGraph(attributePaths = {"tags", "countries", "descripts"})
    @Query("SELECT m FROM Movie m WHERE m.serial = :isSerial ORDER BY m.title")
    List<Movie> findAllMovies(boolean isSerial);

    @EntityGraph(attributePaths = {"tags", "countries", "descripts"})
    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE :title ORDER BY m.title")
    List<Movie> findAllMoviesByTitle(String title);

    @EntityGraph(attributePaths = {"tags", "countries", "descripts"})
    @Query("SELECT m FROM Movie m ORDER BY m.title")
    List<Movie> findAllMovies();

    @EntityGraph(attributePaths = {"tags", "countries", "descripts"})
    @Query("SELECT m FROM Movie m WHERE m.id = :id")
    Optional<Movie> findMovieById(Long id);

    @Query("""
        SELECT m
        FROM Movie m
        WHERE m.internalRating in (4, 5)
        AND m.serial = :isSerial
        ORDER BY m.internalRating desc, m.externalRating desc, m.title
        LIMIT 1
        """)
    Optional<Movie> findBestMovie(boolean isSerial);
}
