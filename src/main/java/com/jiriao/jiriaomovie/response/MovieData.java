package com.jiriao.jiriaomovie.response;

public class MovieData {

    private String title;
    private String posterUrl;
    private String imdbId;

    public MovieData(String title, String posterUrl, String imdbId) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
