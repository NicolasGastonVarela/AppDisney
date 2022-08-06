package com.AppDisney.AppDisney.Repository;

import com.AppDisney.AppDisney.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
