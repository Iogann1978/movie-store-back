package ru.home.moviestore.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PersonId implements Serializable {
    public enum Role {
        ACTOR, DIRECTOR, VOICE
    }
    private Long id;
    private Role role;
}
