package com.example.kilda.movies;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kilda.movies.utilities.MoviesJsonUtils;
import com.example.kilda.movies.utilities.NetworkUtils;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements MovieListAdapter.MovieListAdapterOnClickHandler{

    private RecyclerView mRecyclerView;
    private TextView errorMsg;
    private ProgressBar loadingBar;
    private MovieListAdapter movieListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_movies);
        errorMsg = (TextView) findViewById(R.id.tv_error_loading);
        loadingBar = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,4);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        movieListAdapter = new MovieListAdapter(this);

        mRecyclerView.setAdapter(movieListAdapter);

        loadMoviesList();

    }

    private void loadMoviesList() {
        showMovieDataView();

        new FetchMoviesTask().execute();
    }

    private void showMovieDataView()
    {
        errorMsg.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(Movies movie, int movieId) {
        Intent intent = new Intent(MainActivity.this,MovieDetail.class);
        intent.putExtra("name",movie.getName());
        intent.putExtra("synopsis",movie.getSynopsis());
        intent.putExtra("year",movie.getYear());
        intent.putExtra("image",movieId);

        startActivity(intent);
    }

    public class FetchMoviesTask extends AsyncTask<Void, Void,Movies[]>
    {
        @Override
        protected Movies[] doInBackground(Void... params) {

            Movies[] Movies = null;
            try {
                String jsonResponse = null;
                if(TmdbApi.IsTopRated())
                    jsonResponse = NetworkUtils.getResponseFromHttpUrl(TmdbApi.buildTopRatedRequestURL());
                else{
                    jsonResponse = NetworkUtils.getResponseFromHttpUrl(TmdbApi.buildPopularRequestURL());
                }
                Movies = MoviesJsonUtils.parseJSonToMovies(jsonResponse);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return Movies;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            loadingBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Movies[] Movies) {
            loadingBar.setVisibility(View.INVISIBLE);
            if (Movies != null) {
                showMovieDataView();
                movieListAdapter.setMovieData(Movies);
            } else {
                showErrorMessage();
            }
        }
    }

    public void showErrorMessage()
    {
        mRecyclerView.setVisibility(View.INVISIBLE);
        errorMsg.setVisibility(View.VISIBLE);
    }
}
