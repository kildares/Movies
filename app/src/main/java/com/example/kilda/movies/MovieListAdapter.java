package com.example.kilda.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by kilda on 2/12/2018.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>{

    private final MovieListAdapterOnClickHandler movieListAdapterOnClickHandler;
    private MyMovie[] myMovies;

    public MovieListAdapter(MovieListAdapterOnClickHandler clickHandler)
    {
        movieListAdapterOnClickHandler = clickHandler;
    }

    public interface MovieListAdapterOnClickHandler
    {
        void onClick(MyMovie movie);
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem,viewGroup,false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {
        String movieImg = myMovies[position].getImage();
        holder.movieImg.setImageResource();
        Picasso.with().load();
    }

    @Override
    public int getItemCount()
    {
        if(myMovies == null)
            return 0;
        return myMovies.length;
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView movieName;
        public final ImageView movieImg;

        public MovieListViewHolder(View itemView) {
            super(itemView);
            this.movieName = (TextView) itemView.findViewById(R.id.tv_movie_name);
            this.movieImg = (ImageView) itemView.findViewById(R.id.view_movie_img);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            MyMovie movie = myMovies[adapterPosition];
            movieListAdapterOnClickHandler.onClick(movie);
        }
    }

    public void setMovieData(MyMovie[] myMovieData)
    {
        this.myMovies = myMovieData;
        notifyDataSetChanged();
    }


}
