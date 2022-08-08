package com.AppDisney.AppDisney.Service;

import com.AppDisney.AppDisney.DTO.GenreDTO;
import com.AppDisney.AppDisney.Model.Genre;
import com.AppDisney.AppDisney.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = entityMapping(genreDTO);
        Genre genre1 = genreRepository.save(genre);
        GenreDTO genreResponse = dtoMapping(genre1);
        return genreResponse;
    }

    private GenreDTO dtoMapping(Genre genre){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        genreDTO.setImage(genre.getImage());
        genreDTO.setRelatedMovies(genre.getRelatedMovies());

        return genreDTO;
    }

    //Convierte de DTO a entidad
    private Genre entityMapping(GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setImage(genreDTO.getImage());
        genre.setRelatedMovies(genreDTO.getRelatedMovies());

        return genre;
    }
}
