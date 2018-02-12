package com.example.kilda.movies;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kilda on 2/12/2018.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>{

    private final MovieListAdapterOnClickHandler movieListAdapterOnClickHandler;

    public MovieListAdapter(MovieListAdapterOnClickHandler clickHandler)
    {
        movieListAdapterOnClickHandler = clickHandler;
    }

    public interface MovieListAdapterOnClickHandler
    {
        void onClick(String movie);
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

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public MovieListViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View view) {

        }
    }


}
