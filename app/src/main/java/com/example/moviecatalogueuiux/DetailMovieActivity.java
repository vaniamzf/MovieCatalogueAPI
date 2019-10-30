package com.example.moviecatalogueuiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogueuiux.model.Movies;

import java.util.Objects;

public class DetailMovieActivity extends AppCompatActivity {
    private static final String POSTER_PATH = BuildConfig.POSTER_PATH;
    public static final String EXTRA_MOVIES = "extra-movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ImageView ivPoster = findViewById(R.id.detail_movie_poster);
        TextView tvTitle = findViewById(R.id.detail_movie_title);
        TextView tvOverview = findViewById(R.id.detail_movie_overview);
        TextView tvLanguage = findViewById(R.id.detail_movie_language);
        TextView tvReleaseDate = findViewById(R.id.detail_movie_released);
        TextView tvRating = findViewById(R.id.detail_movie_rating);

        Toolbar toolbar = findViewById(R.id.detail_movie_toolbar);

        Intent intent = getIntent();
        Movies movies = intent.getParcelableExtra(EXTRA_MOVIES);

        Glide.with(this)
                .load(POSTER_PATH +movies.getPosterPath())
                .into(ivPoster);

        tvTitle.setText(movies.getTitle());
        tvOverview.setText(movies.getOverview());
        tvLanguage.setText(movies.getOriginalLanguage());
        tvReleaseDate.setText(movies.getReleaseDate());
        tvRating.setText(String.valueOf(movies.getVoteAverage()));

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(movies.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
