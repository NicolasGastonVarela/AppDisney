package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.MovieDTO;
import com.AppDisney.AppDisney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getmovies")
    public List<MovieDTO> getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @PostMapping("/savemovies")
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.createMovie(movieDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable(name = "id") long id) {
        MovieDTO movieResponse = movieService.updateMovie(movieDTO, id);
        return new ResponseEntity<>(movieResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable(name = "id") long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
    }


}
