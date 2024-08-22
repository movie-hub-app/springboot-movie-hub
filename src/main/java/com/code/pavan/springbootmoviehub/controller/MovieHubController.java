package com.code.pavan.springbootmoviehub.controller;


import com.code.pavan.springbootmoviehub.entity.MovieHub;
import com.code.pavan.springbootmoviehub.repository.MovieHubRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieHubController {

    private final MovieHubRepository movieRepository;

    public MovieHubController(MovieHubRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public String hello() {
        return "Hello from Spring Boot Bean Stalk";
    }


    @GetMapping("/getMovies")
    public List<MovieHub> getAllMovies() {
        return movieRepository.findAll();
    }


    @PostMapping("/saveMovie")
    public MovieHub createMovie(@RequestBody MovieHub movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("movie/{id}")
    public MovieHub updateMovie(@PathVariable Long id, @RequestBody MovieHub movieDetails) {
        MovieHub movie = movieRepository.findById(id).orElseThrow();
        movie.setTitle(movieDetails.getTitle());
        movie.setDescription(movieDetails.getDescription());
        movie.setGenre(movieDetails.getGenre());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRating(movieDetails.getRating());
        movie.setImageUrl(movieDetails.getImageUrl());
        return movieRepository.save(movie);
    }

    @DeleteMapping("movie/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
