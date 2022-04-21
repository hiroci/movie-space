package com.jiriao.jiriaomovie.client.movie;

import okhttp3.*;

import java.io.IOException;

public class MovieClient {

    OkHttpClient client = new OkHttpClient.Builder()
            .build();

    public String searchMovieByTitle(String movieName){

        HttpUrl.Builder urlBuilder = createUrlBuilder();

        urlBuilder.addQueryParameter("s", movieName);

        return executeCall(urlBuilder);
    }

    public String searchMovieById(String movieName){
        HttpUrl.Builder urlBuilder = createUrlBuilder();

        urlBuilder.addQueryParameter("i", movieName);

        return executeCall(urlBuilder);
    }

    private String executeCall(HttpUrl.Builder urlBuilder){
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try{
            Response response = call.execute();
            return response.body().string();
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }

        return "";
    }

    private HttpUrl.Builder createUrlBuilder(){

        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("http://www.omdbapi.com/").newBuilder();
        urlBuilder.addQueryParameter("apikey", "a58ffd3e");

        return  urlBuilder;
    }
}
