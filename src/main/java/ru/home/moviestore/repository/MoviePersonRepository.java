package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.MoviePerson;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviePersonRepository extends JpaRepository<MoviePerson, Long> {
    @Query("SELECT mp FROM MoviePerson mp WHERE mp.movieId = :movieId ORDER BY mp.id")
    List<MoviePerson> findPersonsByMovieId(Long movieId);

    @Query("SELECT mp FROM MoviePerson mp WHERE mp.personId = :personId ORDER BY mp.movieId, mp.role")
    List<MoviePerson> findMoviesByPersonId(Long personId);

    Optional<MoviePerson> findAllByMovieIdAndPersonIdAndRole(Long movieId, Long personId, MoviePerson.Role role);

    void deleteAllByMovieId(Long movieId);
}
