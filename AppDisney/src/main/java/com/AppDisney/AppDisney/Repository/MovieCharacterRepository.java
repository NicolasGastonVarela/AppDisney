package com.AppDisney.AppDisney.Repository;

import com.AppDisney.AppDisney.Model.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {

}


