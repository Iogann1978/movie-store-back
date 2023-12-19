package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Descript;

@Repository
public interface DescriptRepository extends JpaRepository<Descript, Long> {
}
