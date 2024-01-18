package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Country;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    @EntityGraph(attributePaths = {"movies"})
    @Query("SELECT c FROM Country c ORDER BY c.name")
    List<Country> findAll();
}
