package com.week8.movie.movieweek8.fragments;

import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.squareup.picasso.Picasso;
import com.week8.movie.movieweek8.R;
import com.week8.movie.movieweek8.activities.MovieActivity;
import com.week8.movie.movieweek8.model.MovieModel;

/**
 * Created by anushree on 2/12/2018.
 */

public class MovieDetailsFragment extends DialogFragment {
   TextView title;
    YouTubePlayerSupportFragment youtubeFragment;
   RatingBar rating;
   MovieModel movie;
   Context ctx;
    public static final String API_KEY = "AIzaSyBFGWJED0kpO6ncvxhcagLa21yiksUeiHw";

   public MovieDetailsFragment(){
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_layout,null,false);
        title = view.findViewById(R.id.title);
        movie = (MovieModel) getArguments().getParcelable("Movie");
        rating = view.findViewById(R.id.rating);
        youtubeFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.youtubeContent,youtubeFragment).commit();
        youtubeFragment.initialize(API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        youTubePlayer.cueVideo(MovieActivity.videosMap.get(movie.getId()));
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });



        title.setText(movie.getTitle());
        rating.setRating((movie.getVote_average()/2));
        return view;
    }
}
