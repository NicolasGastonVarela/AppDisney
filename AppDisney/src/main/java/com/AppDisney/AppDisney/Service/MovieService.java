package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(Long id);

    MovieDTO createMovie(MovieDTO movieDTO);

    MovieDTO updateMovie(MovieDTO movieDTO, long id);

    void deleteMovie(long id);
}
