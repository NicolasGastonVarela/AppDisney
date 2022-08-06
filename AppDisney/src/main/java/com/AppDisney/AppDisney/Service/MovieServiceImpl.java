package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.MovieDTO;
import com.AppDisney.AppDisney.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        return null;
    }
}
