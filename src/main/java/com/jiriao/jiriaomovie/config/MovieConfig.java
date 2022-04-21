package com.jiriao.jiriaomovie.config;

import com.jiriao.jiriaomovie.client.movie.MovieClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {

    @Bean
    public MovieClient movieClient() {
        return new MovieClient();
    }
}
