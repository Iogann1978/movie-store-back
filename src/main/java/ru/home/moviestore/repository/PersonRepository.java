package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Person;
import ru.home.moviestore.model.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findAllOrderByRoleAscNameAsc();
    List<Person> findAllByRoleOrderByName(PersonId.Role role);
}
