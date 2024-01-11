package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p ORDER BY p.name")
    List<Person> findAll();
    @Query("SELECT p FROM Person p LEFT JOIN MoviePerson mp on p.id = mp.personId WHERE mp.movieId is null")
    List<Person> findNullMovie();
}
