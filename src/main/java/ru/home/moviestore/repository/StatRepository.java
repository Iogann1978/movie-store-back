package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
    @Query("SELECT new Stat(" +
            "COUNT(mp.id)," +
            "COUNT(DISTINCT m1.id)," +
            "COUNT(DISTINCT m2.id)," +
            "SUM(CASE WHEN mp.role = ACTOR THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN mp.role = DIRECTOR THEN 1 ELSE 0 END)," +
            "SUM(CASE WHEN mp.role = COMPOSER THEN 1 ELSE 0 END)," +
            "COUNT(DISTINCT mp.movieId)," +
            "COUNT(DISTINCT mp.personId))" +
            "FROM MoviePerson mp LEFT JOIN Movie m1 ON mp.movieId = m1.id AND m1.serial = false " +
    "LEFT JOIN Movie m2 ON mp.movieId = m2.id AND m2.serial = true")
    Stat getStat();
}
