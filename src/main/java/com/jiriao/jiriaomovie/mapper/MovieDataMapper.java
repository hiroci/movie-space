package com.jiriao.jiriaomovie.mapper;

import com.jiriao.jiriaomovie.response.MovieData;
import com.jiriao.jiriaomovie.response.MovieDataDetail;
import com.jiriao.jiriaomovie.source.MovieDataRaw;

public class MovieDataMapper {

    public static MovieData mapMovieData(MovieDataRaw movieDataRaw){

        MovieData movie = new MovieData(movieDataRaw.getTitle(), movieDataRaw.getPoster(), movieDataRaw.getImdbID());

        return movie;
    }

    public static MovieDataDetail mapMovieDataDetail(MovieDataRaw movieDataRaw){

        MovieDataDetail movie = new MovieDataDetail();

        movie.setTitle(movieDataRaw.getTitle());
        movie.setPosterUrl(movieDataRaw.getPoster());
        movie.setYear(movieDataRaw.getYear());
        movie.setImdbRating(movieDataRaw.getImdbRating());
        movie.setImdbID(movieDataRaw.getImdbID());
        movie.setPlot(movieDataRaw.getPlot());
        movie.setReleased(movieDataRaw.getReleased());
        movie.setType(movieDataRaw.getType());

        return movie;
    }
}
