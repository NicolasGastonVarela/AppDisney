package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieCharacterDTO;
import com.AppDisney.AppDisney.Exception.ResourceNotFoundException;
import com.AppDisney.AppDisney.Model.MovieCharacter;
import com.AppDisney.AppDisney.Repository.MovieCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieCharacterServiceImpl implements MovieCharacterService{

    @Autowired
    private MovieCharacterRepository movieCharacterRepository;

    @Override
    public MovieCharacterDTO createMovieCharacter(MovieCharacterDTO movieCharacterDTO) {
        MovieCharacter movieCharacter = entityMapping(movieCharacterDTO);
        MovieCharacter movieCharacter1 = movieCharacterRepository.save(movieCharacter);
        MovieCharacterDTO movieCharacterResponse = dtoMapping(movieCharacter1);
        return movieCharacterResponse;
    }

    @Override
    public List<MovieCharacterDTO> getAllMovieCharacters() {
        List<MovieCharacter> movieCharacters = movieCharacterRepository.findAll();
        return movieCharacters.stream().map(movieCharacter -> dtoMapping(movieCharacter)).collect(Collectors.toList());
    }

    @Override
    public MovieCharacterDTO getMovieCharacterById(Long id) {
        MovieCharacter movieCharacter = movieCharacterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        return dtoMapping(movieCharacter);
    }

    @Override
    public MovieCharacterDTO updateMovieCharacter(MovieCharacterDTO movieCharacterDTO, long id) {
        MovieCharacter movieCharacter = movieCharacterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        movieCharacter.setName(movieCharacterDTO.getName());
        movieCharacter.setImage(movieCharacterDTO.getImage());
        movieCharacter.setAge(movieCharacterDTO.getAge());
        movieCharacter.setHistory(movieCharacterDTO.getHistory());
        movieCharacter.setRelatedMovies(movieCharacterDTO.getRelatedMovies());
        MovieCharacter updatedMovieCharacter = movieCharacterRepository.save(movieCharacter);
        return dtoMapping(movieCharacter);
    }

    @Override
    public void deleteMovieCharacter(long id) {
        MovieCharacter movieCharacter = movieCharacterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        movieCharacterRepository.delete(movieCharacter);
    }

    //Convierte de entidad a DTO
    private MovieCharacterDTO dtoMapping(MovieCharacter movieCharacter){
        MovieCharacterDTO movieCharacterDTO = new MovieCharacterDTO();
        movieCharacterDTO.setId(movieCharacter.getId());
        movieCharacterDTO.setName(movieCharacter.getName());
        movieCharacterDTO.setImage(movieCharacter.getImage());
        movieCharacterDTO.setAge(movieCharacter.getAge());
        movieCharacterDTO.setHistory(movieCharacter.getHistory());
        movieCharacterDTO.setRelatedMovies(movieCharacter.getRelatedMovies());

        return movieCharacterDTO;
    }

    //Convierte de DTO a entidad
    private MovieCharacter entityMapping(MovieCharacterDTO movieCharacterDTO){
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setName(movieCharacterDTO.getName());
        movieCharacter.setImage(movieCharacterDTO.getImage());
        movieCharacter.setAge(movieCharacterDTO.getAge());
        movieCharacter.setHistory(movieCharacterDTO.getHistory());
        movieCharacter.setRelatedMovies(movieCharacterDTO.getRelatedMovies());

        return movieCharacter;
    }
}

