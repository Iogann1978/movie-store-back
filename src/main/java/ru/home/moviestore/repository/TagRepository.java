package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
}
