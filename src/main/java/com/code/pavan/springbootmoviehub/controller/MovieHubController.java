package com.code.pavan.springbootmoviehub.controller;


import com.code.pavan.springbootmoviehub.entity.MovieHub;
import com.code.pavan.springbootmoviehub.repository.MovieHubRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieHubController {

    private final MovieHubRepository movieRepository;

    public MovieHubController(MovieHubRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<MovieHub> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public MovieHub createMovie(@RequestBody MovieHub movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
