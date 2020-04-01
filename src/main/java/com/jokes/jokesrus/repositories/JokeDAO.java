package com.jokes.jokesrus.repositories;

import com.jokes.jokesrus.entities.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeDAO extends JpaRepository<Joke, Long> {

}