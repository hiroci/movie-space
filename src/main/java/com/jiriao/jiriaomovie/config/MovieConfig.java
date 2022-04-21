package com.jiriao.jiriaomovie.config;

import com.jiriao.jiriaomovie.client.movie.MovieClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MovieConfig{

    @Bean
    public MovieClient movieClient(){
        return new MovieClient();
    }
}
