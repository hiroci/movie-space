package com.jiriao.jiriaomovie.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jms_favorites")
public class FavoriteMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "imdb_id")
    private String imdbId;
    @Column(name = "poster_url")
    private String posterUrl;
    @Column(name = "title")
    private String title;

    public FavoriteMovie(){
    }

    public FavoriteMovie(long id, String imdbId, String posterUrl, String title) {
        this.id = id;
        this.imdbId = imdbId;
        this.posterUrl = posterUrl;
        this.title = title;
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
