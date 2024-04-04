package ru.home.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.home.moviestore.model.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
    @Query("""
         SELECT new Stat(
         COUNT(mp.id),
         COUNT(DISTINCT m1.id),
         COUNT(DISTINCT m2.id),
         COUNT(DISTINCT p1.id),
         COUNT(DISTINCT p2.id),
         COUNT(DISTINCT p3.id),
         COUNT(DISTINCT mp.movieId),
         COUNT(DISTINCT mp.personId),
         'Пусто')
         FROM MoviePerson mp
         LEFT JOIN Movie m1 ON mp.movieId = m1.id AND m1.serial = false
         LEFT JOIN Movie m2 ON mp.movieId = m2.id AND m2.serial = true
         LEFT JOIN Person p1 ON mp.personId = p1.id AND mp.role = ACTOR
         LEFT JOIN Person p2 ON mp.personId = p2.id AND mp.role = DIRECTOR
         LEFT JOIN Person p3 ON mp.personId = p3.id AND mp.role = COMPOSER
         """)
    Stat getStat();
}
