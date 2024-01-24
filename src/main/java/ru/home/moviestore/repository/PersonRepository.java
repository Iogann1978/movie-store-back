package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT new Person(p.id, p.name, p.originName, SUM(CASE WHEN m.serial = false THEN 1 ELSE 0 END), SUM(CASE WHEN m.serial = true THEN 1 ELSE 0 END)) " +
            "FROM Person p JOIN MoviePerson mp ON p.id = mp.personId " +
            "JOIN Movie m ON m.id = mp.movieId " +
            "WHERE mp.role = :role " +
            "GROUP BY p.id, p.name, p.originName ORDER BY p.name")
    List<Person> findAllByRole(MoviePerson.Role role);
    @Query("SELECT p FROM Person p LEFT JOIN MoviePerson mp on p.id = mp.personId WHERE mp.movieId is null")
    List<Person> findNullMovie();
}
