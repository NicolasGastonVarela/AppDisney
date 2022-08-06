package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;
import com.AppDisney.AppDisney.Model.MovieCharacter;
import com.AppDisney.AppDisney.Repository.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCharacterServiceImpl implements MovieCharacterService{

    @Autowired
    private MovieCharacterRepository movieCharacterRepository;

    @Override
    public MovieCharacterDTO createMovieCharacter(MovieCharacterDTO movieCharacterDTO) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setName(movieCharacterDTO.getName());
        movieCharacter.setImage(movieCharacterDTO.getImage());
        movieCharacter.setAge(movieCharacterDTO.getAge());
        movieCharacter.setHistory(movieCharacterDTO.getHistory());
        movieCharacter.setRelatedMovies(movieCharacterDTO.getRelatedMovies());

        MovieCharacter movieCharacter1 = movieCharacterRepository.save(movieCharacter);

        MovieCharacterDTO movieCharacterResponse = new MovieCharacterDTO();
        movieCharacterResponse.setId(movieCharacter1.getId());
        movieCharacterResponse.setName(movieCharacter1.getName());
        movieCharacterResponse.setImage(movieCharacter1.getImage());
        movieCharacterResponse.setAge(movieCharacter1.getAge());
        movieCharacterResponse.setHistory(movieCharacter1.getHistory());
        movieCharacterResponse.setRelatedMovies(movieCharacter1.getRelatedMovies());

        return movieCharacterResponse;
    }
}
