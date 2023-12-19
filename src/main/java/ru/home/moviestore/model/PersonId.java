package ru.home.moviestore.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PersonId implements Serializable {
    public enum Role {
        ACTOR, DIRECTOR
    }
    private String name;
    private Role role;
}
