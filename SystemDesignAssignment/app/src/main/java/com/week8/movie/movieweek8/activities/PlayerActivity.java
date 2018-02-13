package com.week8.movie.movieweek8.activities;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.week8.movie.movieweek8.R;


public class PlayerActivity extends YouTubeBaseActivity {
    YouTubePlayerView player ;
    String videokey;

    public static final String KEY = "key";
    public static final String API_KEY = "AIzaSyBFGWJED0kpO6ncvxhcagLa21yiksUeiHw";
    public static final String TAG = "PlayerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        videokey = getIntent().getStringExtra(KEY);
        player = (YouTubePlayerView)findViewById(R.id.player);
        Log.i(TAG, "moviesURL "+videokey);
        player.initialize(API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.

                        youTubePlayer.loadVideo(videokey);
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });



    }

}
