package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;

import java.util.List;

public interface MovieCharacterService {

    List<MovieCharacterDTO> getAllMovieCharacters();

    MovieCharacterDTO getMovieCharacterById(Long id);

    MovieCharacterDTO createMovieCharacter(MovieCharacterDTO movieCharacterDTO);

    MovieCharacterDTO updateMovieCharacter(MovieCharacterDTO movieCharacterDTO, long id);

    void deleteMovieCharacter(long id);

}
