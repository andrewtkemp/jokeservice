package com.jokes.jokesrus.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JokeTest {
    Joke joke;
    final String joke1 = "This is a Joke";
    final String joke2 = "This is another Joke";
    @BeforeEach
    void setup() {
        joke = new Joke(JokeType.DADJOKES, joke1);
        joke.setId(1L);
    }
    @Test
    void getId() {
        assertEquals(joke.getId(), 1);
    }

    @Test
    void setId() {
        joke.setId(2L);
        assertEquals(joke.getId(), 2);
    }

    @Test
    void getJokeType() {
        assertEquals(joke.getJokeType(), JokeType.DADJOKES);
    }

    @Test
    void setJokeType() {
        joke.setJokeType(JokeType.KIDJOKES);
        assertEquals(joke.getJokeType(), JokeType.KIDJOKES);
    }

    @Test
    void getJoke() {
        assertEquals(joke.getJoke(), joke1);
    }

    @Test
    void setJoke() {
        joke.setJoke(joke2);
        assertEquals(joke.getJoke(), joke2);
    }
}