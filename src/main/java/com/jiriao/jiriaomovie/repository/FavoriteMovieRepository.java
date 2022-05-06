package com.jiriao.jiriaomovie.repository;

import com.jiriao.jiriaomovie.repository.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Long> {
    List<FavoriteMovie> findByImdbId(String imdbId);
    void deleteByImdbId(String imdbId);
}
