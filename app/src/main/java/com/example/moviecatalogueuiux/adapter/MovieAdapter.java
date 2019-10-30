package com.example.moviecatalogueuiux.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogueuiux.BuildConfig;
import com.example.moviecatalogueuiux.DetailMovieActivity;
import com.example.moviecatalogueuiux.R;
import com.example.moviecatalogueuiux.model.Movies;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String POSTER_PATH = BuildConfig.POSTER_PATH;

    private final Context context;
    private final List<Movies> mMoviesList;

    private List<Movies> getMoviesList() {
        return mMoviesList;

    }

    public MovieAdapter(Context context, List<Movies> mMoviesList) {
        this.context = context;
        this.mMoviesList = mMoviesList;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movies, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, int i) {
        final Movies movies = getMoviesList().get(i);

        Glide.with(context)
                .load(POSTER_PATH +mMoviesList.get(i).getPosterPath())
                .into(movieViewHolder.ivPoster);

        movieViewHolder.tvTitle.setText(mMoviesList.get(i).getTitle());
        movieViewHolder.tvOverview.setText(mMoviesList.get(i).getOverview());
        movieViewHolder.lineListMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIES, movies);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout lineListMovie;
        private final ImageView ivPoster;
        private final TextView tvTitle;
        private final TextView tvOverview;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            lineListMovie = itemView.findViewById(R.id.lv_list_movies);
            ivPoster = itemView.findViewById(R.id.iv_list_poster);
            tvTitle = itemView.findViewById(R.id.tv_list_title);
            tvOverview = itemView.findViewById(R.id.tv_list_overview);
        }
    }
}
