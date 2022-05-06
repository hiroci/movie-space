package com.jiriao.jiriaomovie.response;

import com.jiriao.jiriaomovie.repository.entity.FavoriteMovie;

public class FavoriteMovieData {

    private String imdbId = "";
    private String posterUrl = "";
    private  String title = "";

    public FavoriteMovieData() {
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
