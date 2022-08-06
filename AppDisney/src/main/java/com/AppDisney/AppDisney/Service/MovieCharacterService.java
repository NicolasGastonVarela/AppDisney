package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;

import java.util.List;

public interface MovieCharacterService {

    MovieCharacterDTO createMovieCharacter(MovieCharacterDTO movieCharacterDTO);

    List<MovieCharacterDTO> getAllMovieCharacters();

    MovieCharacterDTO getMovieCharacterById(Long id);

    MovieCharacterDTO updateMovieCharacter(MovieCharacterDTO movieCharacterDTO, long id);

    void deleteMovieCharacter(long id);

}
