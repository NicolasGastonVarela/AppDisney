package com.AppDisney.AppDisney.Repository;

import com.AppDisney.AppDisney.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
