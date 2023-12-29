package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.MoviePerson;

@Repository
public interface MoviePersonRepository extends JpaRepository<MoviePerson, Long> {
}
