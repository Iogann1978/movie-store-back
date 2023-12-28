package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.model.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query("SELECT p FROM Person p ORDER BY p.name, p.role")
    List<Person> findAll();
    @Query("SELECT p FROM Person p WHERE p.role = :role ORDER BY p.name, p.role")
    List<Person> findAllByRole(PersonId.Role role);
}
