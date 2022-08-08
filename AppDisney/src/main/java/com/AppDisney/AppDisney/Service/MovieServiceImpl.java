package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieDTO;
import com.AppDisney.AppDisney.Exception.ResourceNotFoundException;
import com.AppDisney.AppDisney.Model.Movie;
import com.AppDisney.AppDisney.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieCharacter -> dtoMapping(movieCharacter)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        return dtoMapping(movie);
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = entityMapping(movieDTO);
        Movie movie1 = movieRepository.save(movie);
        MovieDTO movieResponse = dtoMapping(movie1);
        return movieResponse;
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO, long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        movie.setTitle(movieDTO.getTitle());
        movie.setImage(movieDTO.getImage());
        movie.setCalification(movieDTO.getCalification());
        movie.setCreationDate(movieDTO.getCreationDate());
        movie.setRelatedCharacters(movieDTO.getRelatedCharacters());
        Movie updatedMovie = movieRepository.save(movie);
        return dtoMapping(movie);
    }

    @Override
    public void deleteMovie(long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("MovieCharacter", "id", id));
        movieRepository.delete(movie);
    }

    //Convierte de entidad a DTO
    private MovieDTO dtoMapping(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setImage(movie.getImage());
        movieDTO.setCalification(movie.getCalification());
        movieDTO.setCreationDate(movie.getCreationDate());
        movieDTO.setRelatedCharacters(movie.getRelatedCharacters());

        return movieDTO;
    }

    //Convierte de DTO a entidad
    private Movie entityMapping(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setImage(movieDTO.getImage());
        movie.setCalification(movieDTO.getCalification());
        movie.setCreationDate(movieDTO.getCreationDate());
        movie.setRelatedCharacters(movieDTO.getRelatedCharacters());

        return movie;
    }
}
