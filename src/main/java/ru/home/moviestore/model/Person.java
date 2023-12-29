package ru.home.moviestore.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Entity
public class Person {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
}
