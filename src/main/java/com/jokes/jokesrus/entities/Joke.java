package com.jokes.jokesrus.entities;
import javax.persistence.*;

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
}
