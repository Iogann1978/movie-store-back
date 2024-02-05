package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.MoviePerson;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviePersonRepository extends JpaRepository<MoviePerson, Long> {
    @Query("SELECT mp FROM MoviePerson mp WHERE mp.movieId = :movieId")
    List<MoviePerson> findPersonsByMovieId(Long movieId);
    @Query("SELECT mp FROM MoviePerson mp WHERE mp.personId = :personId ORDER BY mp.movieId, mp.role")
    List<MoviePerson> findMoviesByPersonId(Long personId);
    Optional<MoviePerson> findAllByMovieIdAndPersonIdAndRole(Long movieId, Long personId, MoviePerson.Role role);
    void deleteAllByMovieId(Long movieId);
    @Query("SELECT COUNT(DISTINCT m.id) FROM Movie m JOIN MoviePerson mp ON m.id = mp.movieId WHERE mp.personId = :personId AND mp.role = :role and m.serial = :isSerial")
    Integer getMoviesCountByPersonIdAndRole(Long personId, MoviePerson.Role role, boolean isSerial);
}
