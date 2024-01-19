package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Country;
import ru.home.moviestore.model.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
    @EntityGraph(attributePaths = {"movies"})
    @Query("SELECT t FROM Tag t ORDER BY t.name")
    List<Tag> findAll();
}
