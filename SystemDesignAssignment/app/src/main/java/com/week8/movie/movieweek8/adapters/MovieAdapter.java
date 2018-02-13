package com.week8.movie.movieweek8.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.week8.movie.movieweek8.R;
import com.week8.movie.movieweek8.model.MovieModel;

import java.util.ArrayList;

/**
 * Created by anushree on 2/12/2018.
 */
 class viewHolder{
    ImageView image;
    TextView title;
    TextView overView;
    ImageView play;
    viewHolder(View view){
        image = view.findViewById(R.id.movie_image);
        title = view.findViewById(R.id.title);
        overView = view.findViewById(R.id.mv_overview);
        play  = view.findViewById(R.id.play_button);
    }

}
public class MovieAdapter extends ArrayAdapter {
    Context mCtx;
    ArrayList<MovieModel> movieList;
    boolean isLandScape = false;
    public MovieAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieModel> movies) {
        super(context, resource, movies);
        mCtx = context;
        movieList = movies;
        isLandScape = (mCtx.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)?true:false;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder holder;
        MovieModel movie = movieList.get(position);
        if(convertView==null){
            LayoutInflater li = LayoutInflater.from(mCtx);
            convertView = li.inflate(R.layout.movie_item,null,false);
            holder = new viewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (viewHolder)convertView.getTag();
        }

        holder.title.setText(movie.getTitle());
        holder.overView.setText(movie.getOverView());
        if(isLandScape){
            Picasso.with(mCtx).load(movie.getBackdrop_path()).placeholder(R.drawable.placeholder).into(holder.image);
            holder.play.setVisibility(View.VISIBLE);
        }
        else{
            Picasso.with(mCtx).load(movie.getPoster_path()).placeholder(R.drawable.placeholder).into(holder.image);
            holder.play.setVisibility(View.GONE);

        }

        return convertView;
    }
}
