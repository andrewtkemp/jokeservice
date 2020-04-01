package com.jokes.jokesrus.services;

import com.jokes.jokesrus.entities.Joke;
import com.jokes.jokesrus.repositories.JokeDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JokeService {
    private JokeDAO jokeDao;

    public JokeService (JokeDAO jokeDao){
        this.jokeDao = jokeDao;
    }
    public Joke save(Joke joke) {
        return jokeDao.save(joke);
    }

    public ArrayList<Joke> findAll() {
        return (ArrayList<Joke>) jokeDao.findAll();
    }

    public Joke findById(Long id) {
        if (jokeDao.existsById(id)){
            return jokeDao.findById(id).get();
        }else{
            return null;
        }
    }

    public Joke updateJokeById(Long id, Joke joke) {
        if (jokeDao.existsById(id)){
            joke.setId(id);
            return jokeDao.saveAndFlush(joke);
        }else{
            return null;
        }
    }
    public void delete(Long id) {
        jokeDao.deleteById(id);
    }
}