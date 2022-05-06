package com.jiriao.jiriaomovie.mapper;

import com.jiriao.jiriaomovie.repository.entity.FavoriteMovie;
import com.jiriao.jiriaomovie.response.FavoriteMovieData;

public class FavoriteMovieMapper {

    public FavoriteMovieMapper() {
    }



    public static FavoriteMovieData toFavoriteMovieData(FavoriteMovie favoriteMovie){
        FavoriteMovieData favoriteMovieData = new FavoriteMovieData();

        favoriteMovieData.setImdbId(favoriteMovie.getImdbId());
        favoriteMovieData.setPosterUrl(favoriteMovie.getPosterUrl());
        favoriteMovieData.setTitle(favoriteMovie.getTitle());

        return favoriteMovieData;
    }
}
