package com.example.moviecatalogueuiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogueuiux.model.TV;

import java.util.Objects;

public class DetailTVActivity extends AppCompatActivity {
    private static final String POSTER_PATH = BuildConfig.POSTER_PATH;
    public static final String EXTRA_TV = "extra-tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        ImageView ivPoster = findViewById(R.id.detail_tv_poster);
        TextView tvTitle = findViewById(R.id.detail_tv_title);
        TextView tvOverview = findViewById(R.id.detail_tv_overview);
        TextView tvLanguage = findViewById(R.id.detail_tv_language);
        TextView tvReleaseDate = findViewById(R.id.detail_tv_released);
        TextView tvRating = findViewById(R.id.detail_tv_rating);

        Toolbar toolbar = findViewById(R.id.detail_tv_toolbar);

        Intent intent = getIntent();
        TV tv = intent.getParcelableExtra(EXTRA_TV);

        Glide.with(this)
                .load(POSTER_PATH +tv.getPosterPath())
                .into(ivPoster);

        tvTitle.setText(tv.getName());
        tvOverview.setText(tv.getOverview());
        tvLanguage.setText(tv.getOriginalLanguage());
        tvReleaseDate.setText(tv.getReleaseDate());
        tvRating.setText(String.valueOf(tv.getVoteAverage()));

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(tv.getName());
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
