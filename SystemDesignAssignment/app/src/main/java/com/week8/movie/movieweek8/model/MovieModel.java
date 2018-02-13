package com.week8.movie.movieweek8.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by anushree on 2/12/2018.
 */

public class MovieModel implements Parcelable {

    long id;
    long vote_average;
    String poster_path;
    String title;
    String backdrop_path;
    String overView;
    String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVote_average() {
        return vote_average;
    }

    public void setVote_average(long vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return String.format("http://image.tmdb.org/t/p/w500/%s",poster_path);
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return String.format("http://image.tmdb.org/t/p/w780/%s",backdrop_path);
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    MovieModel(JSONObject obj) throws JSONException {
        id = obj.getLong("id");
        vote_average = obj.getLong("vote_average");
        title = obj.getString("title");
        poster_path = obj.getString("poster_path");
        backdrop_path = obj.getString("backdrop_path");
        overView = obj.getString("overview");
        date = obj.getString("release_date");
    }
    protected MovieModel(Parcel in) {
        id = in.readLong();
        vote_average = in.readLong();
        poster_path = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        overView = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(vote_average);
        dest.writeString(poster_path);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeString(overView);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };


    public static ArrayList<MovieModel> getMovies(JSONArray arr){
        ArrayList<MovieModel> result = new ArrayList<>();
        for(int i=0;i<arr.length();i++){
            try {
                JSONObject obj = arr.getJSONObject(i);
                MovieModel movie = new MovieModel(obj);
                result.add(movie);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
