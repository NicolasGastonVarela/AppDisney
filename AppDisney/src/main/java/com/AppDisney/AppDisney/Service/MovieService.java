package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO createMovie(MovieDTO movieDTO);

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(Long id);

    MovieDTO updateMovie(MovieDTO movieDTO, long id);

    void deleteMovie(long id);
}
