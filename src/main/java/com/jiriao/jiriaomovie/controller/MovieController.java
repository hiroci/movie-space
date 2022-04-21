package com.jiriao.jiriaomovie.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiriao.jiriaomovie.client.movie.MovieClient;
import com.jiriao.jiriaomovie.mapper.MovieDataMapper;
import com.jiriao.jiriaomovie.repository.FavoriteMovieRepository;
import com.jiriao.jiriaomovie.repository.entity.FavoriteMovie;
import com.jiriao.jiriaomovie.response.MovieData;
import com.jiriao.jiriaomovie.response.MovieDataDetail;
import com.jiriao.jiriaomovie.source.MovieDataRaw;
import com.jiriao.jiriaomovie.source.SearchList;

import okhttp3.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://192.168.0.101:4200")
public class MovieController {

    private final MovieClient movieClient;
    private final FavoriteMovieRepository favoriteMovieRepository;
    public MovieController(MovieClient movieClient, FavoriteMovieRepository favoriteMovieRepository) {
        this.movieClient = movieClient;
        this.favoriteMovieRepository = favoriteMovieRepository;
    }

    @GetMapping("/movie")
    public List<MovieData> getMovieList(@RequestParam(value = "s", defaultValue = "") String movieName)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String response = movieClient.searchMovieByTitle(movieName);
        SearchList searchList = mapper.readValue(response, SearchList.class);

        ArrayList<MovieData> movieList = new ArrayList<>();

        for (MovieDataRaw movie : searchList.getList()) {
            movieList.add(MovieDataMapper.mapMovieData(movie));
        }

        return movieList;
    }

    @GetMapping("/movie/{id}")
    public MovieDataDetail getMovie(@PathVariable String id) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String response = movieClient.searchMovieById(id);
        MovieDataRaw movieDataRaw = mapper.readValue(response, MovieDataRaw.class);

        MovieDataDetail movieDataDetail = MovieDataMapper.mapMovieDataDetail(movieDataRaw);

        return movieDataDetail;
    }

    @GetMapping("/favoriteMovie/{id}")
    public List<FavoriteMovie> getMovie2(@PathVariable String id) throws JsonProcessingException {

        return favoriteMovieRepository.findByImdbId(id);


    }
}