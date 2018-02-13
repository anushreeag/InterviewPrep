package com.week8.movie.movieweek8.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.week8.movie.movieweek8.R;
import com.week8.movie.movieweek8.adapters.MovieAdapter;
import com.week8.movie.movieweek8.fragments.MovieDetailsFragment;
import com.week8.movie.movieweek8.model.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {

    public static final String VIDEOS_URL = "https://api.themoviedb.org/3/movie/%s/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String MOVIES_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MovieActivity";
    ListView movieView;
    ArrayList<MovieModel> moviesList;
    public static Map<Long,String> videosMap;
    MovieAdapter adp ;
    OkHttpClient client;
    FragmentManager fm;
    boolean isLandscape;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movieView = findViewById(R.id.list);
        moviesList = new ArrayList<>();
        isLandscape = false;
        videosMap = new HashMap();
        ctx = MovieActivity.this;
        adp = new MovieAdapter(this,R.layout.movie_item,moviesList);
        client = new OkHttpClient();
        fm = getSupportFragmentManager();
        movieView.setAdapter(adp);
        findMovies();
        isLandscape = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)?true:false;
        movieView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!isLandscape) {
                    MovieDetailsFragment frag = new MovieDetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("Movie", moviesList.get(i));
                    frag.setArguments(bundle);
                    frag.show(fm, "Details");
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("key",videosMap.get(moviesList.get(i).getId()));
                    intent.setClass(ctx,PlayerActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void findVideoURL(final MovieModel movie){
        OkHttpClient client1 = new OkHttpClient();
        HttpUrl url = HttpUrl.parse(String.format(VIDEOS_URL, movie.getId()));


        Request request = new Request.Builder().url(url).build();
        client1.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String responseData = response.body().string();
                    JSONObject res =  new JSONObject(responseData);
                    final JSONArray movieArr = (JSONArray) res.getJSONArray("results");
                    String moviesURL = movieArr.getJSONObject(0).getString("key");
                    //Log.i(MovieActivity.TAG, "movies URL found to play movie "+ movie.getId()+"  "+movieArr.getJSONObject(0).getString("key"));
                    videosMap.put(movie.getId(),movieArr.getJSONObject(0).getString("key"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    private void findMovies(){
        HttpUrl url = HttpUrl.parse(MOVIES_URL);
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String responseData = response.body().string();
                    JSONObject res =  new JSONObject(responseData);
                    final JSONArray movieArr = res.getJSONArray("results");
                    moviesList.addAll(MovieModel.getMovies(movieArr));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adp.notifyDataSetChanged();
                        }
                    });
                    for(MovieModel movie : moviesList)
                        findVideoURL(movie);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
