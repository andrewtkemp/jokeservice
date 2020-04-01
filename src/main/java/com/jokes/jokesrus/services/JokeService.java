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
//
//    public Joke findById(Long id) {
//        if (jokeDao.existsById(id)){
//            return jokeDao.findById(id).get();
//        }else{
//            return null;
//        }
//    }
//
//    public List<Joke> findAllByJokeType(JokeType jokeType) {
//        return jokeDao.findAllByJokeType(jokeType);
//    }
//
//    public List<Joke> findAllBySearchStringAndJokeType(String searchString, JokeType jokeType) {
//        if(jokeType != null){
//            return jokeDao.findAllBySearchStringAndJokeType(searchString, jokeType);
//        }else{
//            return jokeDao.findAllBySearchString(searchString);
//        }
//
//    }
//
//    public Joke findRandomJoke(JokeType jokeType) {
//        Long randomId;
//        List<Joke> jokeList;
//        List<Long> idList;
//        Random rand = new Random();
//        if(jokeType != null){
//            jokeList = jokeDao.findAllByJokeType(jokeType);
//        }else{
//            jokeList = jokeDao.findAll();
//        }
//        // store id fields of jokes by mapping with the getId method
//        idList = jokeList.stream().map(Joke::getId).collect(Collectors.toList());
//        randomId = idList.get(rand.nextInt(idList.size()));
//
//        if (jokeDao.existsById(randomId)){
//            return jokeDao.findById(randomId).get();
//        }else{
//            return null;
//        }
//    }
//
//
//
//    //UPDATE
//
//
//    public Joke updateJokeById(Long id, Joke joke) {
//        if (jokeDao.existsById(id)){
//            joke.setId(id);
//            return jokeDao.saveAndFlush(joke);
//        }else{
//            return null;
//        }
//    }
//
//
//    //DELETE
//    public void delete(Long id) {
//        if (jokeDao.existsById(id)) {
//            jokeDao.deleteById(id);
//        }
//    }
}