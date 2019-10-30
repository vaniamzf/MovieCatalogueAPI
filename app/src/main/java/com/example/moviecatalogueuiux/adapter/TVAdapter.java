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
import com.example.moviecatalogueuiux.DetailTVActivity;
import com.example.moviecatalogueuiux.R;
import com.example.moviecatalogueuiux.model.TV;

import java.util.List;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TvViewHolder> {
    private static final String POSTER_PATH = BuildConfig.POSTER_PATH;

    private final Context context;
    private final List<TV> tvList;

    private List<TV> getTvList() {
        return tvList;
    }


    public TVAdapter(Context context, List<TV> tvList) {
        this.context = context;
        this.tvList = tvList;
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movies, viewGroup, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder tvViewHolder, int i) {
        final TV tv = getTvList().get(i);

        Glide.with(context)
                .load(POSTER_PATH +tvList.get(i).getPosterPath())
                .into(tvViewHolder.ivPoster);

        tvViewHolder.tvTitle.setText(tvList.get(i).getName());
        tvViewHolder.tvOverview.setText(tvList.get(i).getOverview());
        tvViewHolder.lineListMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTVActivity.class);
                intent.putExtra(DetailTVActivity.EXTRA_TV, tv);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout lineListMovie;
        private final ImageView ivPoster;
        private final TextView tvTitle;
        private final TextView tvOverview;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            lineListMovie = itemView.findViewById(R.id.lv_list_movies);
            ivPoster = itemView.findViewById(R.id.iv_list_poster);
            tvTitle = itemView.findViewById(R.id.tv_list_title);
            tvOverview = itemView.findViewById(R.id.tv_list_overview);
        }
    }
}
