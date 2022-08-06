package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.GenreDTO;
import com.AppDisney.AppDisney.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        return null;
    }
}
