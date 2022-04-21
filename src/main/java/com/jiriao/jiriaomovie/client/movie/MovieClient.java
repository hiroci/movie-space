package com.jiriao.jiriaomovie.client.movie;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MovieClient {

    private final OkHttpClient client;

    public MovieClient() {
        this.client = new OkHttpClient.Builder().build();
    }

    public String searchMovieByTitle(String movieName) {
        HttpUrl.Builder urlBuilder = createUrlBuilder();

        urlBuilder.addQueryParameter("s", movieName);

        return executeCall(urlBuilder);
    }

    public String searchMovieById(String movieName) {
        HttpUrl.Builder urlBuilder = createUrlBuilder();

        urlBuilder.addQueryParameter("i", movieName);

        return executeCall(urlBuilder);
    }

    private String executeCall(HttpUrl.Builder urlBuilder) {
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return "";
    }

    //TODO mover url da api para application.properties
    //TODO mover apikey para environment variable
    private HttpUrl.Builder createUrlBuilder() {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("http://www.omdbapi.com/").newBuilder();
        urlBuilder.addQueryParameter("apikey", "a58ffd3e");

        return urlBuilder;
    }
}
