package com.jokes.jokesrus.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.jokes.jokesrus.entities.Joke;
import com.jokes.jokesrus.entities.JokeType;
import com.jokes.jokesrus.repositories.JokeDAO;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
class JokeServiceTest {
//    @Autowired
//    private JokeService jokeService;
//
//
//    @Autowired
//    private JokeDAO jokeDAO;
//
//    @Test
//    void saveJoke(){
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        Joke saved = jokeService.save(joke);
//        assertEquals(joke.getJoke(), saved.getJoke());
//    }
//    @Test
//    void getAllJokes(){
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        Joke joke2 = new Joke(JokeType.DADJOKES, "Dad Joke");
//        Joke joke3 = new Joke(JokeType.KIDJOKES, "Kid Joke");
//        ArrayList<Joke> jokes = new ArrayList<>();
//        jokes.add(joke);
//        jokes.add(joke2);
//        jokes.add(joke3);
//        jokeService.save(joke);
//        jokeService.save(joke2);
//        jokeService.save(joke3);
//        ArrayList<Joke> foundJokes = jokeService.findAll();
//        assertEquals(jokes.size(), foundJokes.size());
//    }
//    @Test
//    void getJokeById() {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        Joke savedJoke = jokeService.save(joke);
//        Joke foundJoke = jokeService.findById(savedJoke.getId());
//        assertEquals(savedJoke.getId(), foundJoke.getId());
//    }
//    @Test
//    void getJokeBySearch() {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        ArrayList<Joke> jokes = new ArrayList<>();
//        jokes.add(joke);
//        String query = "tech";
//        ArrayList<Joke> searchResults = jokeService.findAllByQueryString(search);
//        assertEquals(jokes, searchResults);
//    }
//    @Test
//    void updateJokeById() {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        Joke savedJoke = jokeService.save(joke);
//        savedJoke.setJokeType(JokeType.KIDJOKES);
//        Joke actual = jokeService.updateJokeById(savedJoke.getId(), savedJoke);
//        assertEquals(savedJoke.getJokeType(), JokeType.KIDJOKES);
//    }
//    @Test
//    void deleteJokeById() {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        Joke savedJoke = jokeService.save(joke);
//        jokeService.delete(joke.getId());
//        assertNull(jokeService.findById(joke.getId()));
//    }
}