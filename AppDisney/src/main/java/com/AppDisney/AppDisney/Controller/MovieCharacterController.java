package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;
import com.AppDisney.AppDisney.Repository.MovieCharacterRepository;
import com.AppDisney.AppDisney.Service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    /*@GetMapping("?name=nombre")
    public ResponseEntity <List<MovieCharacterDTO>> getCharactersByName(@RequestParam String name) {
        return new ResponseEntity<List<MovieCharacterDTO>>(movieCharacterRepository.findByName(name), HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<MovieCharacterDTO> getMovieCharacterById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(movieCharacterService.getMovieCharacterById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/savecharacters")
    public ResponseEntity<MovieCharacterDTO> saveMovieCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO){
        return new ResponseEntity<>(movieCharacterService.createMovieCharacter(movieCharacterDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MovieCharacterDTO> updateMovieCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO, @PathVariable(name = "id") long id) {
        MovieCharacterDTO movieCharacterResponse = movieCharacterService.updateMovieCharacter(movieCharacterDTO, id);
        return new ResponseEntity<>(movieCharacterResponse, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieCharacter(@PathVariable(name = "id") long id){
        movieCharacterService.deleteMovieCharacter(id);
        return new ResponseEntity<>("Movie Character deleted", HttpStatus.OK);
    }


}
