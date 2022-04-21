package com.jiriao.jiriaomovie.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiriao.jiriaomovie.source.MovieDataRaw;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchList {

    @JsonProperty("Search")
    private List<MovieDataRaw> list;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

    public List<MovieDataRaw> getList() {
        return list;
    }

    public void setList(List<MovieDataRaw> list) {
        this.list = list;
    }
}
