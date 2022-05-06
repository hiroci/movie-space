package com.jiriao.jiriaomovie.mapper;

import com.jiriao.jiriaomovie.repository.entity.FavoriteMovie;
import com.jiriao.jiriaomovie.response.MovieDataDetail;

public class MovieDataDetailMapper {

    public MovieDataDetailMapper() {
    }

    public static FavoriteMovie toFavoriteMovie(MovieDataDetail movieDataDetail){
        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.setImdbId(movieDataDetail.getImdbID());
        favoriteMovie.setPosterUrl(movieDataDetail.getPosterUrl());
        favoriteMovie.setTitle(movieDataDetail.getTitle());

        return favoriteMovie;
    }
}
