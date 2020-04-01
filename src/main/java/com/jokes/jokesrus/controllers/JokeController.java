package com.jokes.jokesrus.controllers;


import com.jokes.jokesrus.entities.Joke;
import com.jokes.jokesrus.entities.JokeType;
import com.jokes.jokesrus.services.JokeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/jokes")
@RestController
public class JokeController {
    private JokeService service;

    public JokeController(JokeService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Joke> createOrder(@RequestBody Joke joke){
        return ResponseEntity.ok(service.save(joke));
    }
    @GetMapping
    public ResponseEntity<ArrayList<Joke>> getAllJokes(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Joke> updateJoke(@PathVariable Long id, @RequestBody Joke joke){
        return ResponseEntity.ok(service.updateJokeById(id, joke));
    }
    @DeleteMapping("/{id}")
    public void deleteJokeById(@PathVariable Long id){
        service.delete(id);
    }
}
