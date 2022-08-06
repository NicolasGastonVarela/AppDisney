package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;
import com.AppDisney.AppDisney.Service.MovieCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class MovieCharacterController {

    @Autowired
    MovieCharacterService movieCharacterService;

    @PostMapping("/savecharacters")
    public ResponseEntity<MovieCharacterDTO> saveMovieCharacter(@RequestBody MovieCharacterDTO movieCharacterDTO){
        return new ResponseEntity<>(movieCharacterService.createMovieCharacter(movieCharacterDTO), HttpStatus.CREATED);
    }

}
