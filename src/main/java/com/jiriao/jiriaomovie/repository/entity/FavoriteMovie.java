package com.jiriao.jiriaomovie.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "jms_favorites")
public class FavoriteMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "imdb_id")
    private String imdbId;

    public FavoriteMovie(){

    }
    public FavoriteMovie(String imdbId){
        this.imdbId = imdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
