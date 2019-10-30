package com.example.moviecatalogueuiux.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TV implements Parcelable {
    @SerializedName("id")
    private final int id;
    @SerializedName("vote_average")
    private final double voteAverage;
    @SerializedName("name")
    private final String name;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("original_language")
    private final String originalLanguage;
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("first_air_date")
    private final String releaseDate;
    @SerializedName("runtime")
    private int runtime;

    public TV(int id, double voteAverage, String name, String posterPath, String originalLanguage, String backdropPath, String overview, String releaseDate) {
        this.id = id;
        this.voteAverage = voteAverage;
        this.name = name;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.backdropPath = backdropPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getName() {
        return name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeDouble(voteAverage);
            dest.writeString(name);
            dest.writeString(posterPath);
            dest.writeString(originalLanguage);
            dest.writeString(backdropPath);
            dest.writeString(overview);
            dest.writeString(releaseDate);
            dest.writeInt(runtime);
        }
        private TV(Parcel in) {
            this.id = in.readInt();
            this.voteAverage = in.readDouble();
            this.name = in.readString();
            this.posterPath = in.readString();
            this.originalLanguage = in.readString();
            this.backdropPath = in.readString();
            this.overview = in.readString();
            this.releaseDate = in.readString();
            this.runtime = in.readInt();
        }

    public static final Parcelable.Creator<TV> CREATOR = new Parcelable.Creator<TV>() {
        @Override
        public TV createFromParcel(Parcel source) {
            return new TV(source);
        }

        @Override
        public TV[] newArray(int size) {
            return new TV[size];
        }
    };
}
