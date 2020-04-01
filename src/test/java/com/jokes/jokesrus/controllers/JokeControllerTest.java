package com.jokes.jokesrus.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokes.jokesrus.entities.Joke;
import com.jokes.jokesrus.entities.JokeType;
import com.jokes.jokesrus.services.JokeService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class JokeControllerTest {
    final String url = "/api/jokes";
    @Autowired
    MockMvc mvc;

    @MockBean
    JokeService jokeService;

    @Autowired
    ObjectMapper mapper;
//    POST: new joke - accept any joke in one of the specified categories
    @Test
    void postNewJoke() throws Exception {
        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
        String json = mapper.writeValueAsString(joke);
//        when(jokeService.save(ArgumentMatchers.any(Joke.class))).thenReturn(json);
        mvc.perform(post(url).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(joke.getId()))
                .andExpect(jsonPath("$.jokeType").value(joke.getJokeType()))
                .andExpect(jsonPath("$.joke").value(joke.getJoke()));
    }
//    GET: all jokes in db
    @Test
    void getAllJokes() throws Exception {
        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
        Joke joke2 = new Joke(JokeType.DADJOKES, "Dad Joke");
        Joke joke3 = new Joke(JokeType.KIDJOKES, "Kid Joke");
        ArrayList<Joke> jokes = new ArrayList<>();
        jokes.add(joke);
        jokes.add(joke2);
        jokes.add(joke3);
        String json = mapper.writeValueAsString(jokes);
//        when(jokeService.getJokes()).thenReturn(jokes);
        mvc.perform(get(url).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(jokes.size())));
    }
//    GET: all jokes containing a given search string (bonus: add optional category to search)
    @Test
    void searchAllJokes() throws Exception {
        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
        Joke joke2 = new Joke(JokeType.DADJOKES, "Dad Joke");
        Joke joke3 = new Joke(JokeType.KIDJOKES, "Kid Joke");
        ArrayList<Joke> jokes = new ArrayList<>();
        jokes.add(joke);
        jokes.add(joke2);
        jokes.add(joke3);
        String json = mapper.writeValueAsString(jokes);
        when(jokeService.findAll()).thenReturn(jokes);
        mvc.perform(get(url).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(jokes.size())));
    }
////    GET: all jokes by category
//    @Test
//    void getAllJokesByCategory() throws Exception {
//        Joke joke = new Joke(JokeType.KNOCKKNOCK, "Knock Knock Joke");
//        Joke joke2 = new Joke(JokeType.KNOCKKNOCK, "Knock Knock Joke2");
//        Joke joke3 = new Joke(JokeType.KNOCKKNOCK, "Knock Knock Joke3");
//        ArrayList<Joke> jokes = new ArrayList<>();
//        jokes.add(joke);
//        jokes.add(joke2);
//        jokes.add(joke3);
//        String json = mapper.writeValueAsString(jokes);
//        when(jokeService.getJokesByCategory(JokeType.KNOCKKNOCK)).thenReturn(jokes);
//        mvc.perform(get(url).content(json).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(jokes.size())));
//    }
////    GET: random joke by optional category (see sql below)
//    @Test
//    void getRandomJoke() throws Exception {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        String json = mapper.writeValueAsString(joke);
//        String randomUrl = url + "/random";
//        mvc.perform(get(randomUrl).content(json).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(jokes.size())));
//    }
////    PATCH: update the category, or text of a joke
//    @Test
//    void updateJoke() throws Exception {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        String json = mapper.writeValueAsString(joke);
//        mvc.perform(patch(url)
//                .param("jokeType", "DADJOKES")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.jokeType", is("DADJOKES")));
//    }
////    DELETE: delete a joke by id
//    @Test
//    void deleteJokeById() throws Exception {
//        Joke joke = new Joke(JokeType.TECHNOLOGY, "Tech Joke");
//        when(jokeService.delete(joke.getId())).thenReturn(null);
//        mvc.perform(delete(url + joke.getId())).andExpect(status().isOk());
//    }
}