package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.GenreDTO;
import com.AppDisney.AppDisney.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping("/savegenre")
    public ResponseEntity<GenreDTO> saveGenre(@RequestBody GenreDTO genreDTO){
        return new ResponseEntity<>(genreService.createGenre(genreDTO), HttpStatus.CREATED);
    }
}
