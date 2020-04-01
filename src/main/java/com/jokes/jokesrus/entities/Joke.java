package com.jokes.jokesrus.entities;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jokes")
public class Joke {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jokeType")
    private JokeType jokeType;
    @Column(name = "joke")
    private String joke;

    public Joke() {
    }

    public Joke(JokeType jokeType, String joke) {
        this.jokeType = jokeType;
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JokeType getJokeType() {
        return jokeType;
    }

    public void setJokeType(JokeType jokeType) {
        this.jokeType = jokeType;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke1 = (Joke) o;
        return id.equals(joke1.id) &&
                jokeType == joke1.jokeType &&
                joke.equals(joke1.joke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jokeType, joke);
    }
}
