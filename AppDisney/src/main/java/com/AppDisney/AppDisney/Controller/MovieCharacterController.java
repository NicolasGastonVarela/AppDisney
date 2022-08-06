package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;
import com.AppDisney.AppDisney.Service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class MovieCharacterController {

    @Autowired
    MovieCharacterService movieCharacterService;

    @GetMapping("/getcharacters")
    public List<MovieCharacterDTO> getMovieCharacters(){
        return movieCharacterService.getAllMovieCharacters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieCharacterDTO> getMovieCharacterById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(movieCharacterService.getMovieCharacterById(id));
    }


    @PostMapping("/savecharacters")
    public ResponseEntity<MovieCharacterDTO> saveMovieCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO){
        return new ResponseEntity<>(movieCharacterService.createMovieCharacter(movieCharacterDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieCharacterDTO> updateMovieCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO, @PathVariable(name = "id") long id) {
        MovieCharacterDTO movieCharacterResponse = movieCharacterService.updateMovieCharacter(movieCharacterDTO, id);
        return new ResponseEntity<>(movieCharacterResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieCharacter(@PathVariable(name = "id") long id){
        movieCharacterService.deleteMovieCharacter(id);
        return new ResponseEntity<>("Movie Character deleted", HttpStatus.OK);
    }


}
