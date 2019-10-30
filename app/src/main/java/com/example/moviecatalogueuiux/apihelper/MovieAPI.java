package com.example.moviecatalogueuiux.apihelper;

import com.example.moviecatalogueuiux.model.Movies;
import com.example.moviecatalogueuiux.model.TV;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("movie/now_playing")
    Single<Scraper<Movies>> findNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("tv/on_the_air")
    Single<Scraper<TV>> findOnTheAirTv(@Query("api_key") String apiKey);
}
