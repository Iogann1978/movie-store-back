package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.MoviePerson;
import ru.home.moviestore.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("""
        SELECT new Person(p.id, p.name, p.originName, COUNT(DISTINCT m1.id), COUNT(DISTINCT m2.id))
        FROM Person p JOIN MoviePerson mp ON p.id = mp.personId
        LEFT JOIN Movie m1 ON m1.id = mp.movieId AND m1.serial = false
        LEFT JOIN Movie m2 ON m2.id = mp.movieId AND m2.serial = true
        WHERE mp.role = :role
        GROUP BY p.id, p.name, p.originName
        """)
    List<Person> findAllByRole(MoviePerson.Role role);

    @Query("""
        SELECT new Person(p.id, p.name, p.originName, COUNT(DISTINCT m1.id), COUNT(DISTINCT m2.id))
        FROM Person p JOIN MoviePerson mp ON p.id = mp.personId
        LEFT JOIN Movie m1 ON m1.id = mp.movieId AND m1.serial = false
        LEFT JOIN Movie m2 ON m2.id = mp.movieId AND m2.serial = true
        WHERE LOWER(p.name) LIKE :name
        GROUP BY p.id, p.name, p.originName
        """)
    List<Person> findAllByName(String name);

    @Query("SELECT p FROM Person p LEFT JOIN MoviePerson mp on p.id = mp.personId WHERE mp.movieId is null")
    List<Person> findNullMovie();

    @Query("""
        SELECT new Person(p.id, p.name, p.originName, COUNT(DISTINCT m1.id), COUNT(DISTINCT m2.id))
        FROM Person p JOIN MoviePerson mp ON p.id = mp.personId
        LEFT JOIN Movie m1 ON m1.id = mp.movieId AND m1.serial = false
        LEFT JOIN Movie m2 ON m2.id = mp.movieId AND m2.serial = true
        WHERE mp.personId = :id
        GROUP BY p.id, p.name, p.originName
        """)
    Optional<Person> findPerson(Long id);

    @Query("""
        SELECT p, COUNT(m.id), AVG(m.internalRating), AVG(m.externalRating)
        FROM Movie m, Person p, MoviePerson mp
        WHERE mp.movieId = m.id AND mp.personId = p.id
        AND m.internalRating IN (4, 5)
        AND mp.role = :role
        GROUP BY p
        ORDER BY 2 DESC, 3 DESC, 4 DESC, p.name
        LIMIT 1
        """)
    Optional<Person> findBestPersonByRole(MoviePerson.Role role);
}
