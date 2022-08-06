package com.AppDisney.AppDisney.Repository;

import com.AppDisney.AppDisney.Model.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
}
