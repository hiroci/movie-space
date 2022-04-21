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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO mudar url para application.properties
@RestController
@CrossOrigin(origins = "http://192.168.0.101:4200")
public class MovieController {

    private final MovieClient movieClient;
    private final FavoriteMovieRepository favoriteMovieRepository;
    private final ObjectMapper mapper;

    public MovieController(MovieClient movieClient, FavoriteMovieRepository favoriteMovieRepository) {
        this.movieClient = movieClient;
        this.favoriteMovieRepository = favoriteMovieRepository;
        this.mapper = new ObjectMapper();
    }

    @GetMapping("/movie")
    public List<MovieData> getMovieListByName(@RequestParam(value = "s", defaultValue = "") String movieNameFilter)
            throws IOException {
        String response = movieClient.searchMovieByTitle(movieNameFilter);
        SearchList searchList = mapper.readValue(response, SearchList.class);

        ArrayList<MovieData> movieList = new ArrayList<>();

        for (MovieDataRaw movie : searchList.getList()) {
            movieList.add(MovieDataMapper.mapMovieData(movie));
        }

        return movieList;
    }

    @GetMapping("/movie/{id}")
    public MovieDataDetail getMovieById(@PathVariable String id) throws JsonProcessingException {
        String response = movieClient.searchMovieById(id);
        MovieDataRaw movieDataRaw = mapper.readValue(response, MovieDataRaw.class);

        return MovieDataMapper.mapMovieDataDetail(movieDataRaw);
    }

    @GetMapping("/favoriteMovie/{id}")
    public List<FavoriteMovie> getFavoriteMovieById(@PathVariable String id) {
        return favoriteMovieRepository.findByImdbId(id);
    }

}