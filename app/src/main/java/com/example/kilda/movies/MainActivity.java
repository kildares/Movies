package com.example.kilda.movies;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kilda.movies.utilities.MoviesJsonUtils;
import com.example.kilda.movies.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements MovieListAdapter.MovieListAdapterOnClickHandler{

    private RecyclerView mRecyclerView;
    private TextView errorMsg;
    private ProgressBar loadingBar;
    private MovieListAdapter movieListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_movies);
        errorMsg = findViewById(R.id.tv_error_loading);
        loadingBar = findViewById(R.id.pb_loading_indicator);

        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,4);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        movieListAdapter = new MovieListAdapter(this);

        mRecyclerView.setAdapter(movieListAdapter);

        loadMoviesList();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadMoviesList();
    }

    private void loadMoviesList() {

        if(NetworkUtils.isNetworkConnected(this))
        {
            showMovieDataView();
            URL url = (TmdbApi.IsTopRated()) ? TmdbApi.buildTopRatedRequestURL() : TmdbApi.buildPopularRequestURL();
            new FetchMoviesTask().execute(url);
        }
        else{
            showErrorMessage();
        }

    }

    private void showMovieDataView()
    {
        errorMsg.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(Movies movie) {
        Intent intent = new Intent(MainActivity.this,MovieDetail.class);
        intent.putExtra("movie",movie);

        startActivity(intent);
    }

    public class FetchMoviesTask extends AsyncTask<URL, Void,Movies[]>
    {

        @Override
        protected Movies[] doInBackground(URL... params) {

            if(params.length==0)
                return null;

            URL reqUrl = params[0];
            Movies[] Movies = null;
            try {
                String jsonResponse;
                jsonResponse = NetworkUtils.getResponseFromHttpUrl(reqUrl);
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

    private void showErrorMessage()
    {
        mRecyclerView.setVisibility(View.INVISIBLE);
        errorMsg.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        MenuItem menuItem = menu.findItem(R.id.item_configure);
        Intent intent = new Intent(MainActivity.this,PreferredConfigurations.class);
        menuItem.setIntent(intent);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(item.getIntent());
        return super.onOptionsItemSelected(item);
    }
}
