package com.example.kilda.movies.utilities;

import com.example.kilda.movies.MyMovie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by kilda on 2/13/2018.
 */

public class MoviesJsonUtils {

    public static final String results = "results";
    public static final String RELEASE_DATE = "release_date";
    public static final String NAME = "title";
    public static final String SYNOPSIS = "overview";
    public static final String IMAGE_PATH = "poster_path";

    public static MyMovie[] parseJSonToMovies(String jsonStr)
    {
        try {
            JSONObject json = new JSONObject(jsonStr);

            JSONArray jsonArray = json.getJSONArray(MoviesJsonUtils.results);

            MyMovie[] movies = new MyMovie[jsonArray.length()];

            for(int i=0 ; i < jsonArray.length() ; i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString(MoviesJsonUtils.NAME);
                String year = jsonObject.getString(MoviesJsonUtils.RELEASE_DATE);
                String synopsis = jsonObject.getString(MoviesJsonUtils.SYNOPSIS);
                String image = jsonObject.getString(MoviesJsonUtils.IMAGE_PATH);

                movies[i] = new MyMovie(name, year, image, synopsis);
            }
            return movies;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
